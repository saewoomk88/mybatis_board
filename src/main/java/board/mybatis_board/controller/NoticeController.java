package board.mybatis_board.controller;

import board.mybatis_board.dto.MembersDto;
import board.mybatis_board.dto.NoticeDto;
import board.mybatis_board.service.NoticeService;
import board.mybatis_board.util.PageMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;
//모든 게시물 찾기
    @GetMapping("notice/list")
    public String findAll(Model model, PageMaker pageMaker)throws Exception{
        model.addAttribute("notice",noticeService.findAll(pageMaker));
        pageMaker.setTotalCount(noticeService.count());
        model.addAttribute("pager",pageMaker);

        return "/board/boardList";
    }
    //게시물 하나 찾기
    @GetMapping("/notice/one")
    public String findOne(Model model,int num) throws Exception{
        model.addAttribute("notice",noticeService.findOne(num));
        return "/board/boardOne";
    }
    //글쓰기
    @GetMapping("/notice/write")
    public String write(Model model, HttpSession session) throws Exception{
        MembersDto members = (MembersDto) session.getAttribute("member");
        String path ="";
        if(members !=null){
            path = "/board/boardInsert";
        }else {
            path = "redirect:/notice/list";
            model.addAttribute("msg","no");
        }
        return path;
    }
    @PostMapping("/notice/write")
    public String write(Model model,NoticeDto noticeDto) throws Exception{
        model.addAttribute(noticeService.write(noticeDto));
        return "redirect:/notice/list";
    }
    //글 수정
    @GetMapping("/notice/modify")
    public String update(Model model, int num) throws Exception{
        model.addAttribute("notice",noticeService.findOne(num));
        return "/board/boardModify";
    }
    @PostMapping("/notice/modify")
    public String update(Model model, NoticeDto noticeDto) throws Exception{
        model.addAttribute(noticeService.update(noticeDto));
        return "redirect:/notice/one";
    }

    //글 삭제
    @GetMapping("/notice/delete")
    public String delete(Model model,int num) throws Exception{
        model.addAttribute(noticeService.delete(num));
        return "redirect:/notice/list";
    }
    //답글 달기


}
