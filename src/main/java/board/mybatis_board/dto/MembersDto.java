package board.mybatis_board.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;


@Getter @Setter
@Alias("membersDto")
public class MembersDto {

    private int num;
    private String id;
    private String pw;
    private String name;
    private String address;
    private String phone;
    @Email
    private String email;
    private String gender;
    private LocalDateTime join_date;



}
