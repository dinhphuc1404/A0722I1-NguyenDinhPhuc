package com.example.bai_tap_2.entity;

public class Search {
    private String search;
    private String result;

    public Search(String search, String result) {
        this.search = search;
        this.result = result;
    }

    public Search() {
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
