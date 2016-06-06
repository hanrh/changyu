/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade;

import com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.breezee.common.server.filter.DubboLocaleFilter;
import org.breezee.common.server.servlet.DubboServletContextInitializer;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * Created by Silence on 2016/5/31.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("org.breezee")
@ImportResource(value = {"classpath:/facade-provider.xml"})
public class FacadeBoot {

    /**
     * 启动程序
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        WebApplicationContext webApplicationContext = (WebApplicationContext) SpringApplication.run(FacadeBoot.class, args);
        ServletContext servletContext = webApplicationContext.getServletContext();
        Object obj = servletContext.getAttribute(ResteasyDeployment.class.getName());
        if (obj != null) {
            ResteasyDeployment resteasyDeployment = (ResteasyDeployment) obj;
            ResteasyJackson2Provider jackson2Provider = new ResteasyJackson2Provider();
            jackson2Provider.setMapper(webApplicationContext.getBean("objectMapper", ObjectMapper.class));
            resteasyDeployment.getProviderFactory().register(jackson2Provider, 0);
        }
    }

    @Bean
    public DispatcherServlet services() {
        return new DispatcherServlet();
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return new DubboServletContextInitializer();
    }

    @Bean
    public DubboLocaleFilter dubboLocaleFilter() {
        return new DubboLocaleFilter();
    }
}
