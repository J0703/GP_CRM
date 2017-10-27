package com.lanou.util;

import java.util.List;

/**
 * Created by dllo on 17/10/27.
 */
public class pageBean<T> {
    private int pageNum;//第几页
    private int pageSize;//每页显示的条目数
    private int tatalRecord;//总的记录数

    private int startIndex;//开始索引
    private int totalPage;//总分页数

    private List<T> date;//分页数据

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTatalRecord() {
        return tatalRecord;
    }

    public void setTatalRecord(int tatalRecord) {
        this.tatalRecord = tatalRecord;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDate() {
        return date;
    }

    public void setDate(List<T> date) {
        this.date = date;
    }
}
