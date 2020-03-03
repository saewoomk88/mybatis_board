package board.mybatis_board.controller;

import board.mybatis_board.dto.MembersDto;
import board.mybatis_board.service.MembersService;
import board.mybatis_board.util.Pager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class MembersController {

    private final MembersService membersService;

    /**
     * 회원가입
     */
    @GetMapping("/join")
    public String join() throws Exception {
        return "member/memberJoin";
    }

    @PostMapping("/join")
    public String join(Model model, MembersDto membersDto) throws Exception {
        model.addAttribute(membersService.join(membersDto));
        return "redirect:/";
    }
    //아이디 중복 체크
    @PostMapping("/idCheck")
    @ResponseBody
    public String findById(@RequestParam("id") String id) throws Exception{
        String findId = membersService.findById(id);

        return findId;
    }

    /**
     * 회원 리스트
     */
    @GetMapping("/member/list")
    public String findAll(Model model, Pager pager) throws Exception {
        model.addAttribute("list", membersService.findAll(pager));
        model.addAttribute("pager", pager);
        return "member/memberList";
    }

    /**
     * 로그인
     */
    @GetMapping("/member/login")
    public String login() throws Exception {
        return "member/memberLogin";
    }

    @PostMapping("/member/login")
    public String findOne(String id, HttpSession session) throws Exception {
        MembersDto one = membersService.findOne(id);
        System.out.println("one = " + one.getName());
        session.setAttribute("member", one);
        return "redirect:/";
    }

    /**
     * 로그아웃
     */
    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    //회원 정보 조회
    @GetMapping("/member/one")
    public String memberOne() {
        return "member/memberOne";
    }

    /**회원 수정**/
    @GetMapping("/member/modify")
    public String modify() {
        return "member/memberForm";
    }

    @PostMapping("/member/modify")
    public String modify(HttpSession session, MembersDto membersDto, Model model) throws Exception {
        MembersDto modifyMember = (MembersDto) session.getAttribute("member");
        membersDto.setNum(modifyMember.getNum());
        int result = membersService.modify(membersDto);
        if (result > 0) {
            session.setAttribute("member", membersDto);
        } else {
            model.addAttribute("msg", "수정실패");
        }
        return "redirect:/member/memberOne";

    }

    /**회원 탈퇴**/
    @GetMapping("/member/delete")
    public String delete(String id,HttpSession session) throws Exception{
        MembersDto loginDto =(MembersDto) session.getAttribute("member");
        int result = membersService.delete(loginDto.getId());
        session.invalidate();

        return "redirect:/";

    }


}
