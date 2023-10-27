package org.example;

import java.util.List;

public class Paging<T> {
    private List<T> dataList;
    private int pageSize;

    public Paging(List<T> dataList,int pageSize){
        this.dataList = dataList;
        this.pageSize = pageSize;
    }

    public List<T> getPage(int pageNumber){
        int startIndex = (pageNumber - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize,dataList.size());
        return dataList.subList(startIndex,endIndex);

    }
}
