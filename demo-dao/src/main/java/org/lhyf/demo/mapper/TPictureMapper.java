package org.lhyf.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.lhyf.demo.pojo.TPicture;
import org.lhyf.demo.pojo.TPictureExample;

import java.util.List;

public interface TPictureMapper {
    int countByExample(TPictureExample example);

    int deleteByExample(TPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPicture record);

    int insertSelective(TPicture record);

    List<TPicture> selectByExampleWithBLOBs(TPictureExample example);

    List<TPicture> selectByExample(TPictureExample example);

    TPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPicture record, @Param("example") TPictureExample example);

    int updateByExampleWithBLOBs(@Param("record") TPicture record, @Param("example") TPictureExample example);

    int updateByExample(@Param("record") TPicture record, @Param("example") TPictureExample example);

    int updateByPrimaryKeySelective(TPicture record);

    int updateByPrimaryKeyWithBLOBs(TPicture record);

    int updateByPrimaryKey(TPicture record);

    List<TPicture> findAll();
}