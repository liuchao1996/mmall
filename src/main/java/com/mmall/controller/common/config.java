package com.mmall.controller.common;

import com.mmall.controller.common.interceptor.AuthorityInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lc
 */
@Configuration
public class config implements WebMvcConfigurer {


    /**
     * 注册过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<SessionExpireFilter> registerFilter() {
        FilterRegistrationBean<SessionExpireFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new SessionExpireFilter());
        filter.addUrlPatterns("*.do");
        return filter;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(new AuthorityInterceptor());
        //拦截路径
        addInterceptor.addPathPatterns("/manage/**");

        //排除路径
        //addInterceptor.excludePathPatterns("/admin/login");
    }


}
