package board.mybatis_board.dao;

import board.mybatis_board.dto.ReplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReplyDao {
    //시퀀스
    int seq() throws Exception;
    //총 댓글 갯수
    int count() throws Exception;
    //게시글 댓글 수
    int bNum() throws Exception;
    //댓글 목록
    List<ReplyDto> findAll(int bNum)throws Exception;
    //댓글 작성
    int write(ReplyDto replyDto) throws Exception;
    //댓글 수정
    int update(ReplyDto replyDto) throws Exception;
    //댓글 삭제
    int delete(int cNum) throws Exception;

}
