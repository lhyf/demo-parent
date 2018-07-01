package org.lhyf.demo.service;

import org.lhyf.demo.pojo.TArticleTag;

import java.util.List;
import java.util.Map;

/****
 * @author YF
 * @date 2018-06-21 11:02
 * @desc ArticleTagService
 *
 **/
public interface ArticleTagService {

    int insert(TArticleTag articleTag);

    Map<Integer, String> getArticleTagIdAndTagName(Integer aritcleId);

    /**
     * 删除文章与标签的关联关系,同时将标签的被引用数减少一
     * @param key
     * @return
     */
    int deleteArticleAndTagById(Integer key);

    /**
     * 通过文章 Id 删除文章与标签的关联关系; 同时更新标签的被引用数
     * @param id
     */
    int deleteArticleAndTagMappingByArticleId(Integer id);

    /**
     * 通过文章id 获取文章标签关联关系
     * @param articleId
     * @return
     */
    List<TArticleTag> getArticleTagByArticleId(Integer articleId);

    /**
     * 通过文章id 删除文章标签关联关系
     * @param articleId
     * @return
     */
    int deleteArticleTagByArticleId(Integer articleId);

    /**
     * 通过标签 id 删除文章标签关联关系
     * @param tagId
     * @return
     */
    int deleteArticleTagByTagId(Integer tagId);

}
