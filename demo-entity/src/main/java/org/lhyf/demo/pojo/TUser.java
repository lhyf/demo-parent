package org.lhyf.demo.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUser {
    private Integer id;

    private Date createDate;

    private Date lastLoginDate;

    private String name;

    private String nickname;

    private String password;

    private String status;

    private List<TArticle> articles = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public List<TArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<TArticle> articles) {
        this.articles = articles;
    }
}