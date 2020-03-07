package board.mybatis_board.service;

import board.mybatis_board.dto.MembersDto;
import board.mybatis_board.util.PageMaker;
import board.mybatis_board.util.Pager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
//@Rollback(false)
class MembersServiceTest {

    @Autowired
    MembersService ms;

  /*  @BeforeEach
    public void asdfd() throws Exception{

        for (int i=0; i<100; i++){
            MembersDto membersDto = new MembersDto();

            membersDto.setId("iu"+i);
            membersDto.setPw("iu"+i);
            membersDto.setName("saewoom"+i);
            membersDto.setAddress("seoul");
            membersDto.setEmail("kkk@natem.com");
            membersDto.setGender("M");
            membersDto.setJoin_date(LocalDateTime.now());

            ms.join(membersDto);
        }


    }*/

     @Test
     public void count() throws Exception{
         //given
         int count = ms.count();
         //when
         assertThat(count).isEqualTo(1);

         //then

     }

     @Test
     public void findAll() throws Exception{
         //given
         PageMaker pager = new PageMaker();
         int totalCount = ms.count();

         List<MembersDto> all = ms.findAll(pager);

         for (MembersDto membersDto : all) {
             System.out.println("membersDto.getName() = " + membersDto.getNum());
         }

         //when

         //then

     }

     @Test
     public void seq() throws Exception{
         //given
         int i = ms.seq();
         //when
         assertThat(i).isEqualTo(2);
         //then

     }
      @Test
      public void join() throws Exception{
          MembersDto membersDto = new MembersDto();

          membersDto.setId("iu");
          membersDto.setPw("iu");
          membersDto.setName("saewoom");
          membersDto.setAddress("seoul");
          membersDto.setEmail("kkk@natem.com");
          membersDto.setGender("M");


          ms.join(membersDto);

          System.out.println("membersDto.getJoin_date() = " + membersDto.getJoin_date());
          MembersDto iu = ms.findOne("iu");

          System.out.println("iu.getJoin_date() = " + iu.getJoin_date());
          
          

      }

}