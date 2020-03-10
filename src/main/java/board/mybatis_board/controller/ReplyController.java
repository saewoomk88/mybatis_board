package board.mybatis_board.controller;

import board.mybatis_board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;


}
