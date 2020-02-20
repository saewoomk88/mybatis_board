package board.mybatis_board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardDto{


    private int num;
    private String writer;
    private String title;
    private String content;
    private int hit;
}

