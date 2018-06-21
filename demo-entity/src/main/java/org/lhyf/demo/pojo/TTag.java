package org.lhyf.demo.pojo;

import java.util.Date;

public class TTag {
    private Integer id;

    private String name;

    private Integer tagCount;

    private Date createTime;

    public TTag() {
    }

    public TTag(String name, Integer tagCount, Date createTime) {
        this.name = name;
        this.tagCount = tagCount;
        this.createTime = createTime;
    }

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
}