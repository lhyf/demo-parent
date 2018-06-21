package org.lhyf.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.lhyf.demo.constant.WebConst;
import org.lhyf.demo.message.vo.ArticleVo;
import org.lhyf.demo.model.Bo.ArticleBo;
import org.lhyf.demo.model.Bo.RestResponseBo;
import org.lhyf.demo.pojo.*;
import org.lhyf.demo.service.*;
import org.lhyf.demo.utils.Commons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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

    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleTagService articleTagService;

    /**
     * 保存文章
     * @param article
     * @param result
     * @return
     */
    @ResponseBody
    @PostMapping("/publish")
    public RestResponseBo publishArticle(@Valid ArticleVo article, BindingResult result){

        String username = (String) Commons.getSession(WebConst.USERNAME_SESSION);
        TUser user = userService.selectByName(username);
        article.setUserId(user.getId());
        TArticle a = articleService.insert(article);

        String tags = article.getTags();
        if(StringUtils.isNotBlank(tags)){
            String[] tag = tags.split(",");
            for(String t:tag){
                TTag tag1 = tagService.saveOrUpdate(new TTag(t, 0, new Date()));
                articleTagService.insert(new TArticleTag(a.getId(),tag1.getId()));
            }
        }

        return RestResponseBo.ok();
    }

    /**
     * 查看文章列表
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model , @RequestParam(value = "page" ,defaultValue = "1") int page) {
        String username = (String) Commons.getSession(WebConst.USERNAME_SESSION);
        TUser user = userService.selectByName(username);

        PageHelper.startPage(page, 2);
        List<ArticleBo> datas = articleService.findOwnAll(user.getId());

        PageInfo<ArticleBo> pi = new PageInfo<>(datas);
        model.addAttribute("articles", pi);
        return "admin/article_list";
    }

    /**
     * 跳转到文章编辑页面
     * @param model
     * @return
     */
    @RequestMapping("/publish")
    public String publish(Model model) {

        List<TCategory> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/article_edit";
    }

    /**
     * 修改文章
     * @param id 文章id
     * @param model
     * @return
     */
    @GetMapping(value = "/{id}")
    public String editArticle(@PathVariable("id") Integer id , Model model){
        ArticleBo articleBo = articleService.selectArticleById(id);
        List<TTag> tags = tagService.selectTagLisByArticleId(id);

        String tagStr = listToString(tags);
        articleBo.setTags(tagStr);

        List<TCategory> categories = categoryService.findAll();

        model.addAttribute("article",articleBo);
        model.addAttribute("categories", categories);
        return "admin/article_edit";
    }


    /**
     * 将List<TTag> 转为 String
     * @param tags
     * @return
     */
    private String listToString(List<TTag> tags){

        StringBuffer sb = new StringBuffer();
        for (TTag t:tags){
            sb.append(t.getName() + ",");
        }
        if(StringUtils.isNotBlank(sb)){
            sb.delete(sb.length()-1,sb.length());
        }
        return sb.toString();
    }


    @ResponseBody
    @PostMapping("/modify")
    public RestResponseBo modify(@Valid ArticleVo article, BindingResult result){

        articleService.updateByExampleWithBLOBs(article);

//        String tags = article.getTags();
//        if(StringUtils.isNotBlank(tags)){
//            String[] tag = tags.split(",");
//            for(String t:tag){
//                TTag tag1 = tagService.saveOrUpdate(new TTag(t, 0, new Date()));
//                articleTagService.insert(new TArticleTag(article.getId(),tag1.getId()));
//            }
//        }

        return RestResponseBo.ok();
    }
}
