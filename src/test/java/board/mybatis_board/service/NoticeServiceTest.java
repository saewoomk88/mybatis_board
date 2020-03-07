package board.mybatis_board.service;

import board.mybatis_board.dto.NoticeDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional

class NoticeServiceTest {

    @Autowired
    NoticeService noticeService;

    @BeforeEach
    public void insertBefore()throws Exception{
        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setWriter("글쓴이");
        noticeDto.setTitle("제목");
        noticeDto.setContent("내용");
        noticeService.write(noticeDto);
        System.out.println("noticeDto.getCreatedDate() = " + noticeDto.getCreatedDate());
    }

    @Test
    public void 글쓰기() throws Exception{
        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setWriter("kim2");
        noticeDto.setTitle("title2");
        noticeDto.setContent("content");

        noticeService.write(noticeDto);

        assertThat(noticeDto.getWriter()).isEqualTo("kim2");
        assertThat(noticeDto.getHit()).isEqualTo(0);
       // assertThat(noticeDto.getNum()).isEqualTo(5);
    }

    @Test
    public void 개시물_총_수() throws Exception{
        int count = noticeService.count();

        assertThat(count).isEqualTo(1);
    }

    @Test
    public void seq() throws Exception{
        int seq = noticeService.seq();

        assertThat(seq).isEqualTo(1);
    }

    @Test
    public void 게시물_하나_찾기() throws Exception{
        NoticeDto one = noticeService.findOne(1);
        assertThat(one.getWriter()).isEqualTo("글쓴이");
    }

    @Test
    public void 글수정() throws Exception{
        NoticeDto one = noticeService.findOne(1);
        System.out.println("one.getCreatedDate() = " + one.getCreatedDate());
        System.out.println("one.getLastModifiedDate() = " + one.getLastModifiedDate());
        one.setTitle("제목2");
        one.setContent("내용2");

        noticeService.update(one);

        NoticeDto refind = noticeService.findOne(1);
        assertThat(refind.getTitle()).isEqualTo("제목2");
        assertThat(refind.getContent()).isEqualTo("내용2");
        System.out.println("refind = " + refind.getLastModifiedDate());
    }

    @Test
    public void 글삭제() throws Exception{
        int i = noticeService.delete(1);
        assertThat(i).isEqualTo(1);
    }






}