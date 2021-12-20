package com.mycsdnshiro.mycsdnshiro.config;


import com.mycsdnshiro.mycsdnshiro.auth.AuthFilter;
import com.mycsdnshiro.mycsdnshiro.auth.AuthRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean("securityManager")
    public SecurityManager securityManager(AuthRealm authRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm);
        securityManager.setRememberMeManager(null);
        return securityManager;
    }


    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shifoFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        //auth过滤
        Map<String, javax.servlet.Filter> filters = new HashMap<>();
        filters.put("auth", new AuthFilter());
        shiroFilter.setFilters(filters);
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
//        auno 匿名访问  auth验证
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/sys/login", "anon");
        filterMap.put("/swagger/**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/doc.html", "anon");
//        下面这个是放行这个接口（不进行权限判断），因为我们登录需要请求这个接口
        filterMap.put("/user/login", "anon");

//除了以上，其他都需要权限验证
        filterMap.put("/**", "auth");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;


    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }


}
