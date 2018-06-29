package org.lhyf.demo.service;

import org.lhyf.demo.message.vo.ArticleVo;
import org.lhyf.demo.model.Bo.ArticleBo;
import org.lhyf.demo.pojo.TArticle;

import java.util.List;

/****
 * @author YF
 * @date 2018-06-13 16:41
 * @desc ArticleService
 *
 **/
public interface ArticleService {
    List<ArticleBo> listOwnAllArticle(Integer userId);
    TArticle insert(ArticleVo vo);

    ArticleBo selectArticleWithCategoryById(Integer id);

    int updateByExampleWithBLOBs(ArticleVo article);

    TArticle selectArticleById(Integer id);

    int deleteArticleById(Integer articleId);
}
