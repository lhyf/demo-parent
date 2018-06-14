package org.lhyf.demo.pojo;

import java.util.ArrayList;
import java.util.List;

public class TCategory {
    private Integer id;

    private String name;

    private List<TArticle> articles = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<TArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<TArticle> articles) {
        this.articles = articles;
    }
}