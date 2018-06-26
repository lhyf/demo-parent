package org.lhyf.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lhyf.demo.constant.WebConst;
import org.lhyf.demo.model.Bo.ArticleBo;
import org.lhyf.demo.pojo.TCategory;
import org.lhyf.demo.pojo.TUser;
import org.lhyf.demo.service.CategoryService;
import org.lhyf.demo.service.UserService;
import org.lhyf.demo.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/****
 * @author YF
 * @date 2018-06-26 23:04
 * @desc CategoryController
 *
 **/
@RequestMapping("/category")
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1") int page){

        PageHelper.startPage(page, 2);
        List<TCategory> list = categoryService.listCategories();
        PageInfo<TCategory> pi = new PageInfo<>(list);
        model.addAttribute("categories",pi);
        return "admin/category";
    }
}
