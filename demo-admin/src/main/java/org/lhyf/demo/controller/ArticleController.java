package org.lhyf.demo.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.lhyf.demo.message.vo.ArticleVo;
import org.lhyf.demo.model.Bo.RestResponseBo;
import org.lhyf.demo.pojo.TArticle;
import org.lhyf.demo.pojo.TCategory;
import org.lhyf.demo.pojo.TUser;
import org.lhyf.demo.service.ArticleService;
import org.lhyf.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
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

    /**
     * 保存文章
     * @param article
     * @param result
     * @return
     */
    @ResponseBody
    @PostMapping("/publish")
    public RestResponseBo publishArticle(@Valid ArticleVo article, BindingResult result){

        Subject subject = SecurityUtils.getSubject();
        TUser user = (TUser) subject.getSession().getAttribute("user");
        article.setUserId(user.getId());

        String tags = article.getTags();
        if(StringUtils.isNotBlank(tags)){
            String[] tag = tags.split(",");

        }
        articleService.insert(article);
        return RestResponseBo.ok();
    }

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
