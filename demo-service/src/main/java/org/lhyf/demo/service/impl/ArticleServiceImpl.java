package org.lhyf.demo.service.impl;

import com.github.pagehelper.PageHelper;
import org.lhyf.demo.constant.WebConst;
import org.lhyf.demo.mapper.TArticleMapper;
import org.lhyf.demo.message.vo.ArticleVo;
import org.lhyf.demo.model.Bo.ArticleBo;
import org.lhyf.demo.pojo.TArticle;
import org.lhyf.demo.pojo.TArticleExample;
import org.lhyf.demo.pojo.TUser;
import org.lhyf.demo.service.ArticleService;
import org.lhyf.demo.service.UserService;
import org.lhyf.demo.utils.Commons;
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

    @Autowired
    private UserService userService;

    /**
     * 使用 文章id 查询文章
     * @param id
     * @return
     */
    @Override
    public ArticleBo selectArticleById(Integer id){
        return articleMapper.selectArticleById(id);
    }

    /**
     * 获取账号对应的所有文章
     * @return
     */
    @Override
    public List<ArticleBo> listOwnAllArticle(Integer userId) {
        return articleMapper.listOwnAllArticle(userId);
    }

    @Override
    public TArticle insert(ArticleVo vo) {


        TArticle article = new TArticle();
        article.setTitle(vo.getTitle());
        article.setUri(vo.getUri());
        article.setCategoryId(vo.getCategory());
        article.setUserId(vo.getUserId());
        article.setCreateTime(new Date());
        article.setStatus(vo.getStatus());
        article.setHits(0);
        article.setPv(0);
        article.setAllowComment(vo.getAllowComment());
        article.setAllowFeed(vo.getAllowFeed());
        article.setAllowPing(vo.getAllowPing());
        article.setContent(vo.getContent());
        articleMapper.insert(article);
        return article;
    }

    @Override
    public int updateByExampleWithBLOBs(ArticleVo article){
        TArticle record = new TArticle();
        record.setId(article.getId());
        record.setCategoryId(article.getCategory());
        record.setTitle(article.getTitle());
        record.setUri(article.getUri());
        record.setStatus(article.getStatus());
        record.setContent(article.getContent());
        record.setAllowPing(article.getAllowPing());
        record.setAllowFeed(article.getAllowFeed());
        record.setAllowComment(article.getAllowComment());
        record.setUpdateTime(new Date());

        return  articleMapper.updateByPrimaryKeySelective(record);
    }

}
