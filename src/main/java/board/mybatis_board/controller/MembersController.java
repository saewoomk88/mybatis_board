package board.mybatis_board.controller;

import board.mybatis_board.dto.MembersDto;
import board.mybatis_board.service.MembersService;
import board.mybatis_board.util.PageMaker;
import board.mybatis_board.util.Pager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    //아작스 아이디 중복 체크
    @PostMapping("/idCheck")
    @ResponseBody
    public String findById(@RequestParam("id") String id) throws Exception {
        return membersService.findById(id);

    }

    /**
     * 회원 리스트
     */
    @GetMapping("/member/list")
    public String findAll(Model model, PageMaker pager) throws Exception {
        model.addAttribute("list", membersService.findAll(pager));
        pager.setTotalCount(membersService.count());
        model.addAttribute("pager", pager);
        return "member/memberList";
    }

    //아작스 로그인 체크
    @ResponseBody
    @PostMapping("/loginCheck")
    public String loginCheck(@ModelAttribute MembersDto membersDto) throws Exception {
        MembersDto login = membersService.login(membersDto);
        String r ="";
        if(login !=null){
            r = "ok";
        }else {
            r = "no";
        }
        return r;
    }


    /**
     * 로그인
     */
    @GetMapping("/member/login")
    public String login() throws Exception {
        return "member/memberLogin";
    }

    @PostMapping("/member/login")
    public String login(MembersDto membersDto, HttpSession session) throws Exception {
        String path;
        if (membersDto != null) {
            MembersDto login = membersService.login(membersDto);
            session.setAttribute("member", login);

            path = "redirect:/";
        } else {
            path = "redirect:/member/login";
        }

        return path;

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

    /**
     * 회원 수정
     **/
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
        return "redirect:/member/one";

    }

    @GetMapping("/member/modifyPw")
    public String modifyPw() {
        return "member/memberPwForm";
    }

    @PostMapping("/member/modifyPw")
    public String modifyPw(HttpSession session, MembersDto membersDto, Model model) throws Exception {
        MembersDto modifyMember = (MembersDto) session.getAttribute("member");
        membersDto.setNum(modifyMember.getNum());
        int result = membersService.modifyPw(membersDto);
        if (result > 0) {
            session.setAttribute("member", modifyMember);
        } else {
            model.addAttribute("msg", "수정실패");
        }
        return "redirect:/member/one";

    }

    //아작스 호출해서 비밀번호가 맞으면 수정하는 페이지로 이동
    @PostMapping("/member/pwCheck")
    @ResponseBody
    public int pwCheck(@RequestParam("id") String id , @RequestParam("pw") String pw, Model model) throws Exception {
        int result = membersService.pwCheck(id, pw);
        int r;
        if(result>0){
             r = 1;
        }else {
            r = 0;
        }
        return r;
    }

    /**
     * 회원 탈퇴
     **/
    @GetMapping("/member/delete")
    public String delete(String id, HttpSession session) throws Exception {
        MembersDto loginDto = (MembersDto) session.getAttribute("member");
        int result = membersService.delete(loginDto.getId());
        System.out.println("result = " + result);
        session.invalidate();

        return "redirect:/";

    }

    @PostMapping("/test")
    @ResponseBody
    public String test(@RequestParam("aa") String aa){
        String k = "";
        if(aa.equals("iu")){
            k = "iuuuuuuuuuuuuuuuu";
        }else {
            k = "ezzzzzzzzzzzzzzzzzzz";
        }
        return k;
    }


}
