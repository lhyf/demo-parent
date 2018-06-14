package org.lhyf.demo.pojo;

public class TArticleTag {
    private Integer id;

   private TArticle article;

   private TTag tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TArticle getArticle() {
        return article;
    }

    public void setArticle(TArticle article) {
        this.article = article;
    }

    public TTag getTag() {
        return tag;
    }

    public void setTag(TTag tag) {
        this.tag = tag;
    }
}