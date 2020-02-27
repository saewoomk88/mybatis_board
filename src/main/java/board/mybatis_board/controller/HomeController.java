package board.mybatis_board.controller;

import board.mybatis_board.dto.MembersDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String  home(){
        return "home";
    }

}
