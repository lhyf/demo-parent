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
//        return categoryMapper.findAll();
        return null;
    }
}
