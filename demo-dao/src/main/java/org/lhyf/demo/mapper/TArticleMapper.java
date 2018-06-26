package org.lhyf.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.lhyf.demo.model.Bo.ArticleBo;
import org.lhyf.demo.pojo.TArticle;
import org.lhyf.demo.pojo.TArticleExample;

import java.util.List;

public interface TArticleMapper {
    int countByExample(TArticleExample example);

    int deleteByExample(TArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TArticle record);

    int insertSelective(TArticle record);

    List<TArticle> selectByExampleWithBLOBs(TArticleExample example);

    List<TArticle> selectByExample(TArticleExample example);

    TArticle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TArticle record, @Param("example") TArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") TArticle record, @Param("example") TArticleExample example);

    int updateByExample(@Param("record") TArticle record, @Param("example") TArticleExample example);

    int updateByPrimaryKeySelective(TArticle record);

    int updateByPrimaryKeyWithBLOBs(TArticle record);

    int updateByPrimaryKey(TArticle record);

    List<ArticleBo> findAll();

    List<ArticleBo> listOwnAllArticle(Integer userId);

    ArticleBo selectArticleById(Integer id);
}