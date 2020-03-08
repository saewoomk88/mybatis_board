package board.mybatis_board.service;

import board.mybatis_board.dao.NoticeDao;
import board.mybatis_board.dto.NoticeDto;
import board.mybatis_board.util.PageMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeDao noticeDao;

    //시퀀스
    public int seq() throws Exception {
        return noticeDao.seq();
    }
    //총 게시물 수
    public int count() throws Exception{
        return noticeDao.count();
    }
    // 게시물 리스트
    public List<NoticeDto> findAll(PageMaker pageMaker)throws Exception{
        return noticeDao.findAll(pageMaker);
    }

        //글 하나 검색
    public NoticeDto findOne(int num) throws Exception {
        return noticeDao.findOne(num);
    }
    //글쓰기
    public int write(NoticeDto noticeDto) throws Exception {
        noticeDto.setNum(seq());
        noticeDto.setCreatedDate(LocalDateTime.now());
        noticeDto.setLastModifiedDate(LocalDateTime.now());
        noticeDto.setHit(0);
        noticeDto.setRef(noticeDto.getNum());
        noticeDto.setStep(0);
        noticeDto.setDepth(0);
        return noticeDao.write(noticeDto);
    }
    //글 수정
    public int update(NoticeDto noticeDto) throws Exception{
        noticeDto.setLastModifiedDate(LocalDateTime.now());
       return noticeDao.update(noticeDto);
    }

    //글 삭제
    public int delete(int num) throws Exception{
        return noticeDao.delete(num);
    }
    //답글 달기

}
