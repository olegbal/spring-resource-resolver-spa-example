package com.github.olegbal.mvnconfig;

import com.github.olegbal.resource_resolvers.CustomResourceResolver;
import com.github.olegbal.enums.ClientResourceLocationList;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticResourceConfig extends WebMvcConfigurerAdapter {

    private static final String[] resource_locations = {
            ClientResourceLocationList.angular.path,
            ClientResourceLocationList.react.path
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").
                addResourceLocations(resource_locations).
                setCachePeriod(0).resourceChain(false).
                addResolver(new CustomResourceResolver());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
    }
}
