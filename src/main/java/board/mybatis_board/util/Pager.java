package board.mybatis_board.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter @Setter

public class Pager {

    //Dao select문에 쓰기위함 between startRow and lastRow
    private int startRow; //limmit
    private int lastRow; //mysql에선 필요없음
    private int curPage;	//게시판 하단 리스트번호
    private int pageList;	//게시물 목록들 //offset


    private int perBlock;	//게시판 하단 리스트번호를 몇개 보여줄지
    private int curBlock;	//게시판에 perBlock가 몇개 있는지
    private int totalBlock;	//게시판에 curBlock가 몇개 있는지
    private int startNum;	//
    private int lastNum;

    public Pager() {
        this.pageList=10;
        this.perBlock=5;
        if(curPage==0){
            this.curPage=1;
        }
    }

    public void makeRow() {
        this.startRow= (getCurPage()-1)*getPageList()+1;
        this.lastRow= getCurPage()*getPageList();
    }

    public void paging(int totalCount) {
        //1. 전체 페이지 리스트 수
        int totalList = totalCount/pageList; //전체 리스트 = 전체 개시물 / 한 페이지 게시물 수
        if(totalCount%pageList>0) {
            totalList++;
        }
        //2. 몇개의 블럭이 필요한지 ( totalBlock)
        this.totalBlock = totalList/perBlock; //전체 블럭 = 전체 리스트 / 한페이지에 보여주는 블럭 수
        if(totalList%perBlock>0) {
            totalBlock++;
        }
        //3.총 curBlock 구하기
        this.curBlock = curPage/perBlock;
        if(curPage%perBlock>0) {
            curBlock++;
        }
        //4.curBlock 로 startNum, lastNum 찾기
        this.startNum = (curBlock-1)*perBlock+1;
        this.lastNum = curBlock*perBlock;
        //5. lastNum 찾아주기
        if(curBlock==totalBlock) {
            this.lastNum=totalList;
        }


    }


}
