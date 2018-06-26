package org.lhyf.demo.service;

import org.lhyf.demo.pojo.TArticleTag;

import java.util.HashMap;
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
}
