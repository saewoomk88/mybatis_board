package board.mybatis_board.dao;

import board.mybatis_board.dto.MembersDto;
import board.mybatis_board.util.Pager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MembersDao {

    int seq() throws Exception;
    int join(MembersDto membersDto) throws Exception;
    MembersDto findOne(String id) throws Exception;
    List<MembersDto> findAll(Pager pager) throws Exception;
    int modify(MembersDto membersDto) throws Exception;
    int delete(String id) throws Exception;
    int count() throws Exception;
    String findById(String id)throws Exception;

}
