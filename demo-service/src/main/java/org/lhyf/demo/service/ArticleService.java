package org.lhyf.demo.service;

import org.lhyf.demo.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/****
 * @author YF
 * @date 2018-06-13 16:41
 * @desc ArticleService
 *
 **/
public interface ArticleService {
    Page<Article> findAll(Pageable pageable);
}
