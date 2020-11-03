package com.example.sam;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class FreemarkerConfig {
    @Bean
    public FreeMarkerConfig freeMarkerConfig(ShiroTag shiroTag){
        FreeMarkerConfigurer config=new FreeMarkerConfigurer();
        config.setTemplateLoaderPath("classpath:/templates/");
        Map<String, Object> variables = new HashMap<>(1);
        variables.put("shiro", shiroTag);
        config.setFreemarkerVariables(variables);
        Properties settings = new Properties();
        settings.setProperty("default_encoding", "utf-8");
        settings.setProperty("number_format", "0.##");
        config.setFreemarkerSettings(settings);
        return config;
    }
}
