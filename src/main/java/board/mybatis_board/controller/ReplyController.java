package board.mybatis_board.controller;

import board.mybatis_board.dto.ReplyDto;
import board.mybatis_board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    //댓글 목록
    @GetMapping("/reply/list")
    @ResponseBody
    public List<ReplyDto> findAll(@RequestParam int bNum) throws Exception{
        return replyService.findAll(bNum);
    }

    //댓글 작성
    @PostMapping("/reply/insert")
    @ResponseBody
    public int write(@RequestParam int bNum, @RequestParam String content, @RequestParam String writer) throws Exception{
        ReplyDto replyDto = new ReplyDto();
        replyDto.setBNum(bNum);
        replyDto.setContent(content);
        replyDto.setWriter(writer);

        return replyService.write(replyDto);
    }

    //댓글 수정
    @PostMapping("/reply/update")
    @ResponseBody
    public int update(@RequestParam int cNum, @RequestParam String content) throws Exception{
        ReplyDto replyDto = new ReplyDto();
        replyDto.setCNum(cNum);
        replyDto.setContent(content);
        return replyService.update(replyDto);
    }

    //댓글 삭제
    @PostMapping("/reply/delete/{cNum}")
    @ResponseBody
    public int delete(@PathVariable int cNum) throws Exception{
        return replyService.delete(cNum);
    }

}
