package board.mybatis_board.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter @Setter
@Alias("noticeDto")
public class NoticeDto extends BoardDto {

    //답글 만들때 필요한 변수
    private int ref;    //그룹핑
    private int step;   //그룹내 순서 (답글끼리의 출력 순서)
    private int depth;  //들여쓰기 (답글표시)


}
