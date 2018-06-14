package org.lhyf.demo.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TTag {
    private Integer id;

    private String name;

    private Set<TArticle> articles = new HashSet<>();

    private Integer tagCount;

    private Date createTime;

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

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Set<TArticle> getArticles() {
        return articles;
    }

    public void setArticles(Set<TArticle> articles) {
        this.articles = articles;
    }
}