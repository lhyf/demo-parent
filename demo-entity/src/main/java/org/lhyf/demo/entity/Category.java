package org.lhyf.demo.entity;

import javax.persistence.*;
import java.util.Set;

/****
 * @author YF
 * @date 2018-06-13 11:14
 * @desc Category 文章分类
 *
 **/

@Entity
@Table(name = "t_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //使用 @ManyToMany 注解来映射多对多关联关系
    //使用 @JoinTable 来映射中间表
    //1. name 指向中间表的名字
    //2. joinColumns 映射当前类所在的表在中间表中的外键
    //2.1 name 指定外键列的列名
    //2.2 referencedColumnName 指定外键列关联当前表的哪一列
    //3. inverseJoinColumns 映射关联的类所在中间表的外键
    @ManyToMany
    @JoinTable(name = "t_category_article", joinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "article_id", referencedColumnName = "id")})
    private Set<Article> articles;

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
        this.name = name;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
