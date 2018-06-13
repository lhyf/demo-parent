package org.lhyf.demo.service.impl;

import org.lhyf.demo.dao.ArticleDao;
import org.lhyf.demo.entity.Article;
import org.lhyf.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/****
 * @author YF
 * @date 2018-06-13 16:51
 * @desc ArticleServiceImpl
 *
 **/

@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleDao.findAll(pageable);
    }
}
