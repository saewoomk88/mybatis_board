package board.mybatis_board.dao;

import board.mybatis_board.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NoticeDao {
    int insert1(NoticeDto noticeDto) throws Exception;

    NoticeDto select(int num) throws Exception;
}
