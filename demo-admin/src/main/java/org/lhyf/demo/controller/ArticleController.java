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
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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
     *
     * @param article
     * @param result
     * @return
     */
    @ResponseBody
    @PostMapping("/publish")
    public RestResponseBo publishArticle(@Valid ArticleVo article, BindingResult result) {

        String username = (String) Commons.getSession(WebConst.USERNAME_SESSION);
        TUser user = userService.selectByName(username);
        article.setUserId(user.getId());
        TArticle a = articleService.insert(article);

        String tags = article.getTags();
        if (StringUtils.isNotBlank(tags)) {
            String[] tag = tags.split(",");
            for (String t : tag) {
                TTag tag1 = tagService.saveOrUpdate(new TTag(t, 0, new Date()));
                articleTagService.insert(new TArticleTag(a.getId(), tag1.getId()));
            }
        }

        return RestResponseBo.ok();
    }

    /**
     * 查看文章列表
     *
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
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
     *
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
     *
     * @param id    文章id
     * @param model
     * @return
     */
    @GetMapping(value = "/{id}")
    public String editArticle(@PathVariable("id") Integer id, Model model) {
        ArticleBo articleBo = articleService.selectArticleById(id);
        List<TTag> tags = tagService.selectTagLisByArticleId(id);

        String tagStr = listToString(tags);
        articleBo.setTags(tagStr);

        List<TCategory> categories = categoryService.findAll();

        model.addAttribute("article", articleBo);
        model.addAttribute("categories", categories);
        return "admin/article_edit";
    }


    /**
     * 将List<TTag> 转为 String
     *
     * @param tags
     * @return
     */
    private String listToString(List<TTag> tags) {

        StringBuffer sb = new StringBuffer();
        for (TTag t : tags) {
            sb.append(t.getName() + ",");
        }
        if (StringUtils.isNotBlank(sb)) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }


    /**
     * 1.查询原文章所有对应记录
     * 2.将记录封装为 中间表ID ,标签名name 组成的map, key=Id value=name
     * 3.判断新传入的标签tag 是否在刚查询的map集合中
     * 4.若存在与map集合中,则从改集合中删除该条记录
     * 5.若不在其中,则执行插入操作
     * 6.按集合中存在的元素去删除DB中中间关联表中的记录.
     * @param article
     * @param result
     * @return
     */
    @ResponseBody
    @PostMapping("/modify")
    public RestResponseBo modify(@Valid ArticleVo article, BindingResult result) {

        Map<Integer, String> map = articleTagService.selectArticleTagIdAndTagName(article.getId());
        String tags = article.getTags();
//        boolean flag = false;
//        if (StringUtils.isNotBlank(tags)) {
//            String[] tag = tags.split(",");
//            Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry<Integer, String> next = it.next();
//                for (String t : tag) {
//                    if (next.getValue().equals(t)) {
//                        it.remove();
//                    }
//                }
//            }
//        }
        boolean flag = false;
        if (StringUtils.isNotBlank(tags)) {
            String[] tag = tags.split(",");
            for (String t : tag) {
                flag = false;
                Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, String> next = it.next();
                    if (next.getValue().equals(t)) {
                        it.remove();
                        flag = true;
                    }
                }
                if(flag){
                    System.out.println("需要添加的标签 : "  + t);
                }
            }
        }


        System.out.println(map);

        return RestResponseBo.ok();
    }
}
