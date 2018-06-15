package org.lhyf.demo.service.impl;

import org.lhyf.demo.dao.CategoryDao;
import org.lhyf.demo.entity.Category;
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
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
