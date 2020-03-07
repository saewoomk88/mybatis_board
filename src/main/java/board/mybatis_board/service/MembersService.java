package board.mybatis_board.service;

import board.mybatis_board.dao.MembersDao;
import board.mybatis_board.dto.MembersDto;
import board.mybatis_board.util.PageMaker;
import board.mybatis_board.util.Pager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MembersService {

    private final MembersDao membersDao;

    public int count() throws Exception{
        return membersDao.count();
    }

    public int seq() throws Exception{
        return membersDao.seq();
    }

    public int join(MembersDto membersDto) throws Exception{
        membersDto.setNum(seq());
        membersDto.setJoin_date(LocalDateTime.now());
        return membersDao.join(membersDto);
    }

    public MembersDto findOne(String id) throws Exception{
        return membersDao.findOne(id);
    }

    public List<MembersDto> findAll(PageMaker pager) throws  Exception{
        return membersDao.findAll(pager);
    }

    public int modify(MembersDto membersDto) throws Exception{
        return membersDao.modify(membersDto);
    }

    public int delete(String id) throws Exception{
        return membersDao.delete(id);
    }

    public String findById(String id) throws Exception{
        return membersDao.findById(id);
    }

    public MembersDto login(MembersDto membersDto) throws  Exception{
        return membersDao.login(membersDto);
    }

    public int pwCheck(String id, String pw)  throws Exception{
        return membersDao.pwCheck(id,pw);
    }

    public int modifyPw(MembersDto membersDto) throws Exception{
        return membersDao.modifyPw(membersDto);
    }
}
