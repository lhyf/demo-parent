package org.lhyf.demo.service.impl;

import org.lhyf.demo.mapper.TArticleMapper;
import org.lhyf.demo.pojo.TArticle;
import org.lhyf.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
