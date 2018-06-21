package org.lhyf.demo.service;

import org.lhyf.demo.pojo.TTag;

import java.util.List;

/****
 * @author YF
 * @date 2018-06-21 10:36
 * @desc TagService
 *
 **/
public interface TagService {

    /**若标签不存在,则执行插入操作,若存在则返回该标签实体,并增加标签计数*/
    TTag saveOrUpdate(TTag tag);


    List<TTag> selectTagLisByArticleId(Integer id);
}
