package board.mybatis_board.dao;

import board.mybatis_board.dto.MembersDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MembersDao {

    int seq() throws Exception;
    int join(MembersDto membersDto) throws Exception;
    MembersDto findOne(String id) throws Exception;
    List<MembersDto> findAll() throws Exception;

}
