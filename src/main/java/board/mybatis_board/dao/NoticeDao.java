package board.mybatis_board.dao;

import board.mybatis_board.dto.NoticeDto;
import board.mybatis_board.util.PageMaker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NoticeDao {
    int seq() throws Exception;
    int count() throws Exception;
    List<NoticeDto> findAll(PageMaker pageMaker)throws Exception;
    NoticeDto findOne(int num) throws Exception;
    int write(NoticeDto noticeDto) throws Exception;
    int update(NoticeDto noticeDto) throws Exception;
    int delete(int num) throws Exception;
    int replyUpdate(NoticeDto noticeDto) throws Exception;
    int reply(NoticeDto noticeDto) throws Exception;

}
