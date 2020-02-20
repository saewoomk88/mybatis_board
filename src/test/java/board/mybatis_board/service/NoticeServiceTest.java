package board.mybatis_board.service;

import board.mybatis_board.dto.NoticeDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(false)
@Transactional
class NoticeServiceTest {

    @Autowired
    NoticeService noticeService;

    @Test
    public void insert() throws Exception{
        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setWriter("kim2");
        noticeDto.setTitle("title2");
        noticeDto.setContent("content");
        noticeDto.setHit(0);
        noticeService.insert1(noticeDto);

        assertThat(noticeDto.getWriter()).isEqualTo("kim2");
       // assertThat(noticeDto.getNum()).isEqualTo(5);
    }

     @Test
     public void test() throws Exception{
         //given
         NoticeDto find = noticeService.select(1);
         System.out.println("find = " + find.getWriter());
         //when

         //then

     }


}