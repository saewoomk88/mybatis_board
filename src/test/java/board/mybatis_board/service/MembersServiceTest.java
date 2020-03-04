package board.mybatis_board.service;

import board.mybatis_board.dto.MembersDto;
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
         Pager pager = new Pager();
         int totalCount = ms.count();
         pager.paging(totalCount);
         pager.makeRow();
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
          //given
          MembersDto member1 = ms.findOne("member1");
            member1.setPhone("12355548");
            member1.setAddress("modify");
            member1.setEmail("kkk22@natem.com");

          System.out.println("member1.getNum() = " + member1.getNum());
          int modify = ms.modify(member1);

          int delete = ms.delete(member1.getId());

          assertThat(delete).isEqualTo(1);


          //when

          //then

      }

}