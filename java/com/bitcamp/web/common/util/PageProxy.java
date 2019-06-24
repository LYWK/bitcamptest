package com.bitcamp.web.common.util;

import java.util.Map;

import com.bitcamp.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * PageProxy
 */
@Component @Data @Lazy
public class PageProxy {
    
    private int pageNum, pageSize, blockSize, startRow, 
                endRow, startPage, endPage, prevBlock, nextBlock, totalCount;
    //
    private String search;
    private boolean existPrev, existNext;

    public void execute(Map<?,?> paramMap){
        //rowCount , 
            //Dim -1 Row scalar count
            int totalCount = Integer.parseInt(String.valueOf(paramMap.get("totalCount")));
            //totalcount   DB에 있는 데이터
            
          
            //Dim -2 Page scalar info 
            String _pageNum = (String)paramMap.get("page_num");
            pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);// 1_5 
            String _pageSize =  (String)paramMap.get("page_size");
            pageSize = (_pageSize == null) ? 5 : Integer.parseInt(_pageSize);// 한페이지당 5개의 게시글 
            // blockSize =  블록사이즈 기본값 5
             //totalCount = db에 있는 테이블에서 가져옴..  
             int nmg = totalCount % pageSize; // 나머지 게시글 수 
             int pageCount = (nmg == 0)? totalCount / pageSize : totalCount / pageSize + 1; //페이지 수 
             //startRow
             startRow = (pageNum - 1) * pageSize  ;
             //endRow
             endRow = (totalCount > pageNum * pageSize) ? pageNum * pageSize : totalCount;

            
             //Dim -3 block scalar info
            String _blockSize = (String)paramMap.get("block_size");
            blockSize = (_blockSize == null) ? 5 : Integer.parseInt(_blockSize);
            int blockNum = (pageNum - 1) / blockSize;
            
            existPrev = (startPage - pageSize) > 0;
            existNext = (startPage + pageSize) <=  pageCount;
            
            startPage = (existPrev)? blockNum * blockSize  + 1 : 1;
            endPage = (endPage > pageCount) ? pageCount : startPage + (blockSize - 1);

            prevBlock = startPage - pageSize; 
            nextBlock = startPage + pageSize;
            search = (String)paramMap.get("search");
           
        }
    
}