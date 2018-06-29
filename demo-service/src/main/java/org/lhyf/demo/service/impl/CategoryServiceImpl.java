package org.lhyf.demo.service.impl;

import org.lhyf.demo.mapper.TCategoryMapper;
import org.lhyf.demo.pojo.TCategory;
import org.lhyf.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 * @author YF
 * @date 2018-06-13 15:24
 * @desc CategoryServiceImpl
 *
 **/
@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private TCategoryMapper categoryMapper;

    @Override
    public List<TCategory> findAll() {
        return categoryMapper.findAll();
    }

    @Override
    public List<TCategory> listCategories() {
        return categoryMapper.findAll();
    }

    @Override
    public int update(TCategory category) {
        return categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public int save(TCategory category) {
        return categoryMapper.insertSelective(category);
    }

    @Override
    public int delete(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int incrCategoryCountByPrimaryKey(Integer id) {
        if(id != null){
            return categoryMapper.incrCategoryCountByPrimaryKey(id);
        }
        return 0;
    }

    @Override
    public int decrCategoryCountByPrimaryKey(Integer id) {
        if(id != null){
            return categoryMapper.decrCategoryCountByPrimaryKey(id);
        }
        return 0;
    }
}
