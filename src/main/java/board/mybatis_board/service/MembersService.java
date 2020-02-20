package board.mybatis_board.service;

import board.mybatis_board.dao.MembersDao;
import board.mybatis_board.dto.MembersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersService {

    @Autowired
    MembersDao membersDao;

    public int seq() throws Exception{
        return membersDao.seq();
    }

    public int join(MembersDto membersDto) throws Exception{
        return membersDao.join(membersDto);
    }

    public MembersDto findOne(String id) throws Exception{
        return membersDao.findOne(id);
    }

    public List<MembersDto> findAll() throws  Exception{
        return membersDao.findAll();
    }
}
