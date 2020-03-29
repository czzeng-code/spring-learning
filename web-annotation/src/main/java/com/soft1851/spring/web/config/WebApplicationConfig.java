package com.soft1851.spring.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Zeng
 * @ClassName WebApplicationConfig
 * @Description web应用配置（替代之前的web.xm1）
 * @Date 2020/3/24
 * @Version 1.0
 **/
public class WebApplicationConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        ctx.register(WebMvcConfig.class);

        ctx.setServletContext(servletContext);

        ctx.refresh();

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));

        registration.addMapping("/");

        registration.setLoadOnStartup(1);
    }
}
