package org.lhyf.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.lhyf.demo.message.vo.ArticleVo;
import org.lhyf.demo.pojo.TArticleTag;
import org.lhyf.demo.pojo.TArticleTagExample;

import java.util.List;

public interface TArticleTagMapper {
    int countByExample(TArticleTagExample example);

    int deleteByExample(TArticleTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TArticleTag record);

    int insertSelective(TArticleTag record);

    List<TArticleTag> selectByExample(TArticleTagExample example);

    TArticleTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TArticleTag record, @Param("example") TArticleTagExample example);

    int updateByExample(@Param("record") TArticleTag record, @Param("example") TArticleTagExample example);

    int updateByPrimaryKeySelective(TArticleTag record);

    int updateByPrimaryKey(TArticleTag record);


    int update(ArticleVo article);
}