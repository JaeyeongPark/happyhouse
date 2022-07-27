package com.ssafy.util;

import java.util.Arrays;

import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy.FirstCharBasedValidator;

public class PageNavigation {
    private boolean startRange; // 초반 범위?
    private boolean endRange; // 마지막 범위?
    private int totalCount; // 총글수
    private int newCount; // 새글수
    private int totalPageCount; // 총페이지수
    private int currentPage; // 현재페이지번호
    private int naviSize; // 네비게이션 범위 수
    private int countPerPage; // 한페이지당 글갯수
    private String navigator; // 페이징.
    private int startPage;
    private int endPage;
    private int nextPageVal;
    private int prevPageVal;
    private int[] pagenum;

@Override
public String toString() {
    return "PageNavigation [startRange=" + startRange + ", endRange=" + endRange + ", totalCount=" + totalCount
            + ", newCount=" + newCount + ", totalPageCount=" + totalPageCount + ", currentPage=" + currentPage
            + ", naviSize=" + naviSize + ", countPerPage=" + countPerPage + ", navigator=" + navigator
            + ", startPage=" + startPage + ", endPage=" + endPage + ", nextPageVal=" + nextPageVal
            + ", prevPageVal=" + prevPageVal + ", pagenum=" + Arrays.toString(pagenum) + "]";
}

public int[] getPagenum() {
    return pagenum;
}

public void setPagenum(int[] pagenum) {
    this.pagenum = pagenum;
}

public int getNextPageVal() {
    return nextPageVal;
}

public void setNextPageVal(int nextPageVal) {
    this.nextPageVal = nextPageVal;
}

public int getPrevPageVal() {
    return prevPageVal;
}

public void setPrevPageVal(int prevPageVal) {
    this.prevPageVal = prevPageVal;
}

public int getStartPage() {
    return startPage;
}

public void setStartPage(int startPage) {
    this.startPage = startPage;
}

public int getEndPage() {
    return endPage;
}

public void setEndPage(int endPage) {
    this.endPage = endPage;
}

public boolean isStartRange() {
    return startRange;
}

public void setStartRange(boolean startRange) {
    this.startRange = startRange;
}

public boolean isEndRange() {
    return endRange;
}

public void setEndRange(boolean endRange) {
    this.endRange = endRange;
}

public int getTotalCount() {
    return totalCount;
}

public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
}

public int getNewCount() {
    return newCount;
}

public void setNewCount(int newCount) {
    this.newCount = newCount;
}

public int getTotalPageCount() {
    return totalPageCount;
}

public void setTotalPageCount(int totalPageCount) {
    this.totalPageCount = totalPageCount;
}

public int getCurrentPage() {
    return currentPage;
}

public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
}

public int getNaviSize() {
    return naviSize;
}

public void setNaviSize(int naviSize) {
    this.naviSize = naviSize;
}

public int getCountPerPage() {
    return countPerPage;
}

public void setCountPerPage(int countPerPage) {
    this.countPerPage = countPerPage;
}

public String getNavigator() {
    return navigator;
}

public void makeNavigator() {
    int startPage = (currentPage - 1) / naviSize * naviSize + 1;
    int endPage = startPage + naviSize - 1;
    if(endPage > totalPageCount)
        endPage = totalPageCount;
    
    this.startPage = startPage;
    this.endPage = endPage;
//        StringBuilder buffer = new StringBuilder();
//        buffer.append("        <ul class=\"pagination\"> \n");
//        buffer.append("            <li class=\"page-item\" data-pg=\"1\"> \n");
//        buffer.append("                <a href=\"javascript:void(0);\" class=\"page-link\">최신</a> \n");
//        buffer.append("            </li> \n");
//        buffer.append(
//                "            <li class=\"page-item\" data-pg=\"" + (this.startRange ? 1 : (startPage - 1)) + "\"> \n");
//        buffer.append("                <a href=\"javascript:void(0);\" class=\"page-link\">이전</a> \n");
//        buffer.append("            </li> \n");
//        for (int i = startPage; i <= endPage; i++) {
//            buffer.append("            <li class=\"" + (currentPage == i ? "page-item active" : "page-item")
//                    + "\" data-pg=\"" + i + "\"><a href=\"javascript:void(0);\" class=\"page-link\">" + i + "</a></li> \n");
//        }
//        buffer.append(
//                "            <li class=\"page-item\" data-pg=\"" + (this.endRange ? endPage : (endPage + 1)) + "\"> \n");
//        buffer.append("                <a href=\"javascript:void(0);\" class=\"page-link\">다음</a> \n");
//        buffer.append("            </li> \n");
//        buffer.append("            <li class=\"page-item\" data-pg=\"" + totalPageCount + "\"> \n");
//        buffer.append("                <a href=\"javascript:void(0);\" class=\"page-link\">마지막</a> \n");
//        buffer.append("            </li> \n");
//        buffer.append("        </ul> \n");

//        this.navigator = buffer.toString();
        this.nextPageVal = (this.endRange ? endPage : (endPage + 1));
        this.prevPageVal = (this.startRange ? 1 : (startPage - 1));
        this.pagenum = new int[endPage-startPage+1];
        int index = 0;
        for (int i = startPage; i <= endPage; i++) {
            this.pagenum[index] = i;
            index+=1;
        }
    }
}