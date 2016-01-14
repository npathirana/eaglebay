
package com.eagle.commons.dao.util;

public class Pageable {

    public static final int PAGE_SIZE_DEFAULT = 25;

    private int pageSize = PAGE_SIZE_DEFAULT;
    private int pageNumber;
    private String sort;

    public Pageable(int pageNumber, int pageSize) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public Pageable(int pageNumber, int pageSize, String sort) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.sort = sort;
    }


    public Pageable(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    public int getOffset() {
        int start = (pageNumber - 1) * pageSize;
        start = start < 0 ? 0 : start;
        return start;
    }

}
