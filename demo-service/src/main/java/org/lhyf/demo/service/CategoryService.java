package org.lhyf.demo.service;

import org.lhyf.demo.entity.Category;

import java.util.List;

/****
 * @author YF
 * @date 2018-06-13 15:21
 * @desc CategoryService
 *
 **/
public interface CategoryService {
    List<Category> findAll();
}
