package org.lhyf.demo.service;

import org.lhyf.demo.pojo.TArticleTag;

import java.util.Map;

/****
 * @author YF
 * @date 2018-06-21 11:02
 * @desc ArticleTagService
 *
 **/
public interface ArticleTagService {

    int insert(TArticleTag articleTag);

    Map<Integer,String> selectArticleTagIdAndTagName(Integer aritcleId);
}
