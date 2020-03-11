package board.mybatis_board.service;

import board.mybatis_board.dao.ReplyDao;
import board.mybatis_board.dto.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyDao replyDao;
    //댓글 목록
    public List<ReplyDto> findAll() throws Exception{
        return replyDao.findAll();
    }
    //댓글 입력
    public int write(ReplyDto replyDto) throws Exception{
        replyDto.setCNum(seq());
        return replyDao.write(replyDto);
    }
    //댓글 수정
    public int update(ReplyDto replyDto) throws Exception{
        return replyDao.update(replyDto);
    }
    //댓글 삭제
    public int delete(int cNum) throws Exception{
        return replyDao.delete(cNum);
    }
    //시퀀스
    public int seq() throws Exception {
        return replyDao.seq();
    }

}
