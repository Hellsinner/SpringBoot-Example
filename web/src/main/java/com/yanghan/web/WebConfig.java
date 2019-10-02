package com.yanghan.web;

import com.yanghan.web.commpent.DemoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by yanghan on 2019-10-01.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor())
        .addPathPatterns("/interceptor/**")
        .excludePathPatterns("/no/interceptor/**");
    }
}
