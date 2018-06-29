package org.lhyf.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lhyf.demo.model.Bo.RestResponseBo;
import org.lhyf.demo.pojo.TCategory;
import org.lhyf.demo.service.CategoryService;
import org.lhyf.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        PageHelper.startPage(page, 10);
        List<TCategory> list = categoryService.listCategories();
        PageInfo<TCategory> pi = new PageInfo<>(list);
        model.addAttribute("categories",pi);
        return "admin/category";
    }

    @ResponseBody
    @PostMapping("/update")
    public RestResponseBo update(@RequestParam("id") Integer id, @RequestParam("name") String name){
        TCategory category = new TCategory();
        category.setId(id);
        category.setName(name);
        categoryService.update(category);

        return RestResponseBo.ok();
    }


    @ResponseBody
    @PostMapping("/save")
    public RestResponseBo save(@RequestParam("name") String name){
        TCategory category = new TCategory();
        category.setName(name);
        categoryService.save(category);
        return RestResponseBo.ok();
    }

    @ResponseBody
    @PostMapping("/delete")
    public RestResponseBo delete(@RequestParam("id") Integer id){
        categoryService.delete(id);
        return RestResponseBo.ok();
    }
}
