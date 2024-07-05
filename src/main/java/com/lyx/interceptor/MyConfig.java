package com.lyx.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/4
 * @desc
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                // addPathPatterns 定义拦截的路径
                // excludePathPatterns 定义放行的路径
                // .addPathPatterns("/*")
                .addPathPatterns("/*");
                // .excludePathPatterns("/login*");
    }
}
