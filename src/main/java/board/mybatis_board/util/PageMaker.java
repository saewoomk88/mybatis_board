package board.mybatis_board.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("PageMaker")
public class PageMaker {

    private int page;           //보여줄 페이지 번호
    private int perPageNum;     //페이지당 보여줄 게시글 수

    public PageMaker(){
        //생성자
        this.page=1;
        this.perPageNum=10;
    }

    public void setPage(int page) {
        if(page<=0){
            this.page=1;
            return;
        }
        this.page = page;

    }
    public void setPerPageNum(int perPageNum) {

        if(perPageNum <= 0 || perPageNum > 100) {
            this.perPageNum = 10;
            return;
        }

        this.perPageNum = perPageNum;
    }

    public int getPageStart(){
        return (this.page-1)*perPageNum;
    }

    private int totalCount;         //게시판 전체 글 수
    private int displayPageNum =5;     //게시판 화면에서 한번에 보여질 페이징 갯수

    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;

        calcData();
    }

    private void calcData() {
        endPage = (int) (Math.ceil(getPage()/(double)displayPageNum) * displayPageNum);
        startPage = (endPage-displayPageNum)+1;
        int tempEndPage = (int)(Math.ceil(totalCount/(double)getPerPageNum()));
        if(endPage > tempEndPage){
            endPage = tempEndPage;
        }
        prev = startPage ==1 ? false : true;
        next = endPage * getPerPageNum() >= totalCount ? false : true;
    }



}
