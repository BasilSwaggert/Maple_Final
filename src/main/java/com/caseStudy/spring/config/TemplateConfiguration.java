package com.caseStudy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

//This class controls how my front end is viewed by implementing Apache Tiles.
@Configuration
public class TemplateConfiguration implements WebMvcConfigurer {

	//Basic view resolver
    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }

    //Needed to set up Apache Tiles to organize my front end, manages my JSP.
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[] {
        		"/WEB-INF/tiles/tiles.xml",
        		"/WEB-INF/tiles/tiles_login.xml",
                "/WEB-INF/tiles/tiles_dashboard.xml", 
                "/WEB-INF/tiles/tiles_users.xml",
                "/WEB-INF/tiles/tiles_category.xml",
                "/WEB-INF/tiles/tiles_status.xml",
                "/WEB-INF/tiles/tiles_tickets.xml"
        });
        return configurer;
    }
}