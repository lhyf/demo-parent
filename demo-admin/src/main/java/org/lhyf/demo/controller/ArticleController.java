package org.lhyf.demo.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lhyf.demo.pojo.TArticle;
import org.lhyf.demo.pojo.TCategory;
import org.lhyf.demo.service.ArticleService;
import org.lhyf.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/****
 * @author YF
 * @date 2018-06-12 22:26
 * @desc ArticleController
 *
 **/
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;


    @RequestMapping("/test")
    public String test(Model model){

        PageHelper.startPage(1, 2);
        List<TArticle> datas = articleService.findAll();

        PageInfo<TArticle> pi = new PageInfo<>(datas);


        String s = JSON.toJSONString(pi);
        System.out.println("===>" + s);

        model.addAttribute("articles", pi);
        return "admin/test";
    }

    @RequestMapping("/list")
    public String list(Model model) {

        PageHelper.startPage(1, 2);
        List<TArticle> datas = articleService.findAll();

        PageInfo<TArticle> pi = new PageInfo<>(datas);


        String s = JSON.toJSONString(pi);
        System.out.println("===>" + s);

        model.addAttribute("articles", pi);
        return "admin/article_list";
    }

    @RequestMapping("/publish")
    public String publish(Model model) {
        List<TCategory> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
//        model.addAttribute("article",new Article());
        return "admin/article_edit";
    }
}
