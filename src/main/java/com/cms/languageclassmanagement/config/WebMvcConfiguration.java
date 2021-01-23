package com.cms.languageclassmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
      /*  registry.addViewController("/home").setViewName("/index");
        registry.addViewController("/index").setViewName("/index"); */
        //registry.addViewController("/admin/addsinger").setViewName("addsinger");
      //  registry.addViewController("/index").setViewName("index");
       // registry.addViewController("/admin/addalbum").setViewName("addalbum");

    }




}
