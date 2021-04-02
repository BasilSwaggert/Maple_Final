package com.caseStudy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TemplateConfiguration implements WebMvcConfigurer {

    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }
//    //Commented due to not having implemented these files in the current build
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[] {
                "/WEB-INF/tiles/tiles.xml",
                "/WEB-INF/tiles/tiles_dashboard.xml",
                "/WEB-INF/tiles/tiles_login.xml"
                
        });
        return configurer;
    }
}