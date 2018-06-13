package org.lhyf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/****
 * @author YF
 * @date 2018-06-12 22:26
 * @desc ArticleController
 *
 **/
@Controller
@RequestMapping("/article")
public class ArticleController {

    @RequestMapping("")
    public String list(){

        return "admin/rticle_list";
    }

    @RequestMapping("/publish")
    public String publish(){

        return "admin/rticle_edit";
    }
}
