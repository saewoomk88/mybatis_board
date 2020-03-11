package board.mybatis_board.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Getter @Setter
@Alias("replyDto")
public class ReplyDto {

    private int cNum;
    private int bNum;
    private String content;
    private String writer;
    private LocalDateTime reg_date;


}
