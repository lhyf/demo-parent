package org.lhyf.demo.controller;

import com.alibaba.fastjson.JSON;
import org.lhyf.demo.entity.Article;
import org.lhyf.demo.entity.Category;
import org.lhyf.demo.service.ArticleService;
import org.lhyf.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @RequestMapping("/list")
    public String list(Model model){
        Pageable pageable =PageRequest.of(0, 5);
        Page<Article> datas = articleService.findAll(pageable);
        datas.getContent();
        datas.hasPrevious();
        datas.hasNext();
        String s = JSON.toJSONString(datas);
        System.out.println("===>" + s);
        datas.getTotalPages();
        model.addAttribute("articles",datas);
        return "admin/rticle_list";
    }

    @RequestMapping("/publish")
    public String publish(Model model){
       List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
//        model.addAttribute("article",new Article());
        return "admin/article_edit";
    }
}
