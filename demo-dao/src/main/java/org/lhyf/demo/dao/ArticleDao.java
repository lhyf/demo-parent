package org.lhyf.demo.dao;

import org.lhyf.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/****
 * @author YF
 * @date 2018-06-13 16:51
 * @desc ArticleDao
 *
 **/
public interface ArticleDao extends JpaRepository<Article, Integer> {

}
