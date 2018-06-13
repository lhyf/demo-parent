package org.lhyf.demo.dao;

import org.lhyf.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/****
 * @author YF
 * @date 2018-06-13 15:25
 * @desc CategoryDao
 *
 **/
public interface CategoryDao extends JpaRepository<Category, Integer> {
}
