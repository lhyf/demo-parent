package org.lhyf.demo.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.lhyf.demo.model.Bo.RestResponseBo;
import org.lhyf.demo.model.Bo.StatisticsBo;
import org.lhyf.demo.model.Vo.CommentVo;
import org.lhyf.demo.model.Vo.ContentVo;
import org.lhyf.demo.service.ISiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/****
 * @author YF
 * @date 2018-06-12 16:39
 * @desc IndexController
 *
 **/

@Controller
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Resource
    private ISiteService siteService;

    @GetMapping(value = "/login")
    public String login() {
        return "admin/login";
    }

    @ResponseBody
    @PostMapping(value = "/login")
    public RestResponseBo login(String username,String password,boolean remeber_me){

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        UsernamePasswordToken upToken = new UsernamePasswordToken(username,password);

        try{
            upToken.setRememberMe(remeber_me);
            subject.login(upToken);
            session.setAttribute("username", username);
            String userName = (String) session.getAttribute("username");
        }catch (UnknownAccountException e){
            return RestResponseBo.fail(500,"账号不存在!");
        }catch (IncorrectCredentialsException e){
            return RestResponseBo.fail(500,"密码错误!");
        }catch (LockedAccountException e){
            return RestResponseBo.fail(500,"账号锁定!");
        }catch (AuthenticationException e){
            return RestResponseBo.fail(500,"登录失败!");
        }
        logger.info("登录成功!");
        return RestResponseBo.ok();
    }

    /**
     * 页面跳转
     * @return
     */
    @GetMapping(value = {"","/index"})
    public String index(HttpServletRequest request){
        logger.info("Enter admin index method");
        List<CommentVo> comments = siteService.recentComments(5);
        List<ContentVo> contents = siteService.recentContents(5);
        StatisticsBo statistics = siteService.getStatistics();
        // 取最新的20条日志
//        List<LogVo> logs = logService.getLogs(1, 5);

        request.setAttribute("comments", comments);
        request.setAttribute("articles", contents);
        request.setAttribute("statistics", statistics);
//        request.setAttribute("logs", logs);
        logger.info("Exit admin index method");
        return "admin/index";
    }

}
