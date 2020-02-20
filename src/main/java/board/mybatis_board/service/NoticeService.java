package board.mybatis_board.service;

import board.mybatis_board.dao.NoticeDao;
import board.mybatis_board.dto.NoticeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    public int insert1(NoticeDto noticeDto) throws Exception{
        return noticeDao.insert1(noticeDto);
    }

    public NoticeDto select(int num) throws Exception{
        return noticeDao.select(num);
    }
}
