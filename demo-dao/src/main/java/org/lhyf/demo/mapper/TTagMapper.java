package org.lhyf.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.lhyf.demo.pojo.TTag;
import org.lhyf.demo.pojo.TTagExample;

import java.util.List;

public interface TTagMapper {
    int countByExample(TTagExample example);

    int deleteByExample(TTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTag record);

    int insertSelective(TTag record);

    List<TTag> selectByExample(TTagExample example);

    TTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTag record, @Param("example") TTagExample example);

    int updateByExample(@Param("record") TTag record, @Param("example") TTagExample example);

    int updateByPrimaryKeySelective(TTag record);

    int updateByPrimaryKey(TTag record);

    int incrTagCountByPrimaryKey(Integer id);


    int decrTagCountByPrimaryKey(Integer id);

    List<TTag> selectTagLisByArticleId(Integer id);

    List<TTag> getAllTags();
}