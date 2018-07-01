package org.lhyf.demo.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.lhyf.demo.shiro.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/****
 * @author YF
 * @date 2018-06-12 15:06
 * @desc ShiroConfig
 *
 **/
@Configuration
public class ShiroConfig {


    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        sourceAdvisor.setSecurityManager(securityManager());
        return sourceAdvisor;
    }

    @Bean
    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setMaxAge(3600);
        simpleCookie.setName("rememberme");
        return simpleCookie;
    }

    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(simpleCookie());
        return rememberMeManager;
    }

    @Bean
    @DependsOn(value="redisTemplate")
    public RedisCache redisCache() {
        RedisCache redisCache = new RedisCache();
        return redisCache;
    }

    @Bean
    public RedisCacheManager redisCacheManager() {
        RedisCacheManager cacheManager = new RedisCacheManager();
        return cacheManager;
    }


    @Bean
    @DependsOn(value="redisSessionDao")
    public CustomSessionManager customSessionManager() {
        CustomSessionManager sessionManager = new CustomSessionManager();
        sessionManager.setSessionDAO(sessionDao());
        sessionManager.setGlobalSessionTimeout(3600*1000);
        return sessionManager;
    }

    @Bean
    @DependsOn(value="redisTemplate")
    public RedisSessionDao sessionDao() {
        RedisSessionDao sessionDao = new RedisSessionDao();
        return sessionDao;
    }

    /**
     * 加密方式: 1024次 MD5
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1024);
        return matcher;
    }

    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;

    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        securityManager.setSessionManager(customSessionManager());
        securityManager.setCacheManager(redisCacheManager());
        securityManager.setRememberMeManager(rememberMeManager());

        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/login");
        bean.setUnauthorizedUrl("/403");

        Map<String, String> chains = new LinkedHashMap<>();
        chains.put("/login", "anon");
        chains.put("/logout", "logout");
        chains.put("/admin/login", "anon");
        chains.put("/admin/css/**", "anon");
        chains.put("/admin/images/**", "anon");
        chains.put("/admin/js/**", "anon");
        chains.put("/admin/plugins/**", "anon");
        chains.put("/admin/logout", "anon");
        chains.put("/403", "anon");
        chains.put("/**", "authc");


        bean.setFilterChainDefinitionMap(chains);
        return bean;
    }
}
