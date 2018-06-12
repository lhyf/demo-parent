package org.lhyf.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/****
 * @author YF
 * @date 2018-06-12 09:45
 * @desc WebMvcConfig
 *
 * 在旧版中，一般继承 WebMvcConfigurerAdapter类，但由于2.0后，WebMvcConfigurer 接口
 **/

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private BaseInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                //告知拦截器：/static/admin/** 与 /static/user/** 不需要拦截 （配置的是 路径）
                .excludePathPatterns("/static/admin/**", "/static/user/**");


    }
}
