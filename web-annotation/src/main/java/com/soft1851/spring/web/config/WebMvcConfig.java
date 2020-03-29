package com.soft1851.spring.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * @author Zeng
 * @ClassName WebMvcConfig
 * @Description TOOD
 * @Date 2020/3/24
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.soft1851.spring.web")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        return new SpringResourceTemplateResolver();
    }

    private ITemplateResolver templateResolver() {
        springResourceTemplateResolver().setPrefix("classpath:/templates/");
        springResourceTemplateResolver().setSuffix(".html");
        springResourceTemplateResolver().setCharacterEncoding("UTF-8");
        springResourceTemplateResolver().setTemplateMode(TemplateMode.HTML);
        return springResourceTemplateResolver();
    }

    @Bean
    public TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}
