package com.bianjq.spring.formdto;

public class CommentParam {
    private int blogId;
    private int pageSize;
    private int pageIndex;
    private String searchContent;

    @Override
    public String toString() {
        return "CommentParam{" +
                "blogId=" + blogId +
                ", pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", searchContent='" + searchContent + '\'' +
                '}';
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }
}
