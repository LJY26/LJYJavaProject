package com.ljy.web0007.util;

/**
 * 页信息
 */
public class Page {
    private int everyPage;//每页条数
    private int totalCount;//总条数
    private int totalPage;//总页数
    private int currentPage;//当前页数
    private  int baginIndex;//开始记录
    private boolean hasPrePage;//是否前一页
    private boolean hasNextPage;//是否有后一页


    public Page() {
    }

    public Page(int everyPage, int totalCount, int totalPage, int currentPage, int baginIndex, boolean hasPrePage, boolean hasNextPage) {
        this.everyPage = everyPage;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.baginIndex = baginIndex;
        this.hasPrePage = hasPrePage;
        this.hasNextPage = hasNextPage;
    }

    public int getEveryPage() {
        return everyPage;
    }

    public void setEveryPage(int everyPage) {
        this.everyPage = everyPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getBaginIndex() {
        return baginIndex;
    }

    public void setBaginIndex(int baginIndex) {
        this.baginIndex = baginIndex;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}
