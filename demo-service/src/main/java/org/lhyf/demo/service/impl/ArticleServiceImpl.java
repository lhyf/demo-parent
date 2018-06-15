package org.lhyf.demo.service.impl;

import org.lhyf.demo.mapper.TArticleMapper;
import org.lhyf.demo.message.vo.ArticleVo;
import org.lhyf.demo.pojo.TArticle;
import org.lhyf.demo.pojo.TCategory;
import org.lhyf.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/****
 * @author YF
 * @date 2018-06-13 16:51
 * @desc ArticleServiceImpl
 *
 **/

@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private TArticleMapper articleMapper;

    @Override
    public List<TArticle> findAll() {

        return articleMapper.findAll();
    }

    @Override
    public void insert(ArticleVo vo) {
        TCategory category = new TCategory();
        category.setId(vo.getCategory());

        TArticle article = new TArticle();
        article.setTitle(vo.getTitle());
        article.setUri(vo.getUri());
        article.setCategory(category);
        article.setStatus(vo.getStatus());
        article.setAllowComment(vo.getAllowComment());
        article.setAllowFeed(vo.getAllowFeed());
        article.setAllowPing(vo.getAllowPing());
        article.setContent(vo.getContent());
        article.setCreateTime(new Date());
        article.setHits(0);
        article.setPv(0);
//        article.setUser();
    }


}
