package org.lhyf.demo.service;

import org.lhyf.demo.pojo.TCategory;

import java.util.List;

/****
 * @author YF
 * @date 2018-06-13 15:21
 * @desc CategoryService
 *
 **/
public interface CategoryService {
    List<TCategory> findAll();

    List<TCategory> listCategories();

    int update(TCategory category);

    int save(TCategory category);

    int delete(Integer id);

    /**
     * 通过 分类id 增加引用数 +1
     * @param id
     * @return
     */
    int incrCategoryCountByPrimaryKey(Integer id);


    /**
     * 通过 分类id 减少引用数 -1
     * @param id
     * @return
     */
    int decrCategoryCountByPrimaryKey(Integer id);
}
