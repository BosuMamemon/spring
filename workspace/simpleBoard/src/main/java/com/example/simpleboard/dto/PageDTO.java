package com.example.simpleboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageDTO {
    private int startPage;
    private int endPage;
    private int blockPage;
    private int currentPage;
    private int totalPage;
    private String word;
    private String field;

    public PageDTO(int count, int currentPage, int pageSize, int blockPage) {
        this.totalPage = (count / pageSize) + (((count % pageSize) == 0) ? 0 : 1);
        this.currentPage = currentPage;
        this.blockPage = blockPage;
        this.startPage = ((getCurrentPage() - 1) / getBlockPage()) * getBlockPage() + 1;
        this.endPage = getStartPage() + getBlockPage() - 1;
        if(getTotalPage() < getEndPage()) this.endPage = getTotalPage();
    }

    public String toString() {
        return "startPage: " + getStartPage() + "\n"
                + "endPage: " + getEndPage() + "\n"
                + "blockPage: " + getBlockPage() + "\n"
                + "currentPage: " + getCurrentPage() + "\n"
                + "totalPage: " + getTotalPage() + "\n";
    }
}
