package org.lhyf.demo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.util.LinkedHashMap;
import java.util.Map;

//@Configuration
public class ShiroConfig {

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/login");
        bean.setUnauthorizedUrl("/403");


        Map<String, String> chain= new LinkedHashMap<>();
        chain.put("/","anon");
        chain.put("/login","anon");
        chain.put("/**","authc");
        bean.setFilterChainDefinitionMap(chain);
        return bean;
    }


    @Bean
    public FilterRegistrationBean someFilterRegistration(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new DelegatingFilterProxy("shiroFilter"));
        bean.addUrlPatterns("/*");
        bean.setEnabled(true);
        bean.setDispatcherTypes(DispatcherType.REQUEST);
        return bean;
    }

}
