package org.lhyf.demo.interceptor;

import org.lhyf.demo.utils.Commons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/****
 * @author yangfan
 * @date 2018-06-12 09:33
 * @desc BaseInterceptor
 *
 **/

@Controller
public class BaseInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);

    @Autowired
    private Commons commons;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        logger.debug(request.getMethod() + " : " + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

//        logger.debug("postHandle...");
        request.setAttribute("commons", commons);//一些工具类和公共方法
    }

}
