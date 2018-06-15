package org.lhyf.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/****
 * @author YF
 * @date 2018-06-13 10:42
 * @desc Article 文章实体
 *
 **/
@Entity
@Table(name = "t_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String uri;

    @Column(name = "create_time")

    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;

    @Column(columnDefinition = "longtext")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
    private String type;
    private String status;

    /**
     * 标签
     */
    private String tags;

    /**分类*/
    @ManyToMany(mappedBy = "articles")
    private Set<Category> categories;

    /**
     * 评论
     */
    @OrderBy("create_time")
    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    /**
     * 允许ping
     */
    private boolean allowPing;
    /**
     * 允许评论
     */
    private boolean allowFeed;
    /**
     * 允许订阅
     */
    private boolean allowComment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public boolean isAllowPing() {
        return allowPing;
    }

    public void setAllowPing(boolean allowPing) {
        this.allowPing = allowPing;
    }

    public boolean isAllowFeed() {
        return allowFeed;
    }

    public void setAllowFeed(boolean allowFeed) {
        this.allowFeed = allowFeed;
    }

    public boolean isAllowComment() {
        return allowComment;
    }

    public void setAllowComment(boolean allowComment) {
        this.allowComment = allowComment;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
