package org.lhyf.demo.message.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/****
 * @author YF
 * @date 2018-06-15 17:00
 * @desc ArticleVo
 *
 * 前端向后台提交数据
 **/
@Data
public class ArticleVo {
    private Integer id;

    @NotNull
    private String title;

    private String uri;

    /**分类*/
    private int category;


    private String status;

    private Integer userId;

    /**标签*/
    private String tags;

    private Boolean allowFeed;

    private Boolean allowPing;

    private Boolean allowComment;

    @NotNull
    private String content;


}
