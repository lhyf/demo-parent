package org.lhyf.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lhyf.demo.model.Bo.RestResponseBo;
import org.lhyf.demo.pojo.TTag;
import org.lhyf.demo.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/****
 * @author YF
 * @date 2018-06-30 17:41
 * @desc TagController
 *
 **/

@Controller
@RequestMapping("/tag")
public class TagController {

    private final Logger logger = LoggerFactory.getLogger(TagController.class);

    @Autowired
    private TagService tagService;

    @RequestMapping("/list")
    public String list(Model model , @RequestParam(value = "page",defaultValue = "1") int page){

        PageHelper.startPage(page, 10);
        List<TTag> tags = tagService.getAllTags();
        PageInfo<TTag> pi = new PageInfo<>(tags);

        model.addAttribute("tags",pi);
        return "admin/tag";
    }

    @ResponseBody
    @PostMapping("/save")
    public RestResponseBo save(String name){
        tagService.save(name);
        return RestResponseBo.ok();
    }

    @ResponseBody
    @PostMapping("/update")
    public RestResponseBo update(Integer id,String  name){
        tagService.updateTagNameById(id,name);
        return RestResponseBo.ok();
    }

    @ResponseBody
    @PostMapping("/delete")
    public RestResponseBo delete(Integer id){
        tagService.deleteByPrimaryKey(id);
        return RestResponseBo.ok();
    }
}
