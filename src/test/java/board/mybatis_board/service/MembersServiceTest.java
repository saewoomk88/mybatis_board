package board.mybatis_board.service;

import board.mybatis_board.dto.MembersDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MembersServiceTest {

    @Autowired
    MembersService membersService;

    @BeforeEach
    public void memberset() throws Exception{
        MembersDto membersDto = new MembersDto();

        membersDto.setNum(membersService.seq());
        membersDto.setId("member1");
        membersDto.setPw("123123");
        membersDto.setName("saewoom");
        membersDto.setAddress("seoul");
        membersDto.setEmail("kkk@natem.com");
        membersDto.setGender("M");
        membersDto.setJoin_date(LocalDateTime.now());

        membersService.join(membersDto);

        MembersDto membersDto1 = new MembersDto();

        membersDto1.setNum(membersService.seq());
        membersDto1.setId("member2");
        membersDto1.setPw("123123");
        membersDto1.setName("saewoom2");
        membersDto1.setAddress("seoul2");
        membersDto1.setEmail("kkk2@natem.com");
        membersDto1.setGender("M");
        membersDto1.setJoin_date(LocalDateTime.now());

        membersService.join(membersDto1);

    }

     @Test
     public void seq() throws Exception{
         //given
         int i = membersService.seq();
         //when
         assertThat(i).isEqualTo(2);
         //then

     }
      @Test
      public void join() throws Exception{
          //given
          MembersDto member1 = membersService.findOne("member1");

          List<MembersDto> all = membersService.findAll();

          assertThat(all.get(0).getName()).isEqualTo(member1.getName());


          //when

          //then

      }

}