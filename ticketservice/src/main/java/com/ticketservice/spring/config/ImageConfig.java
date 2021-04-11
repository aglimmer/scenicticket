package com.ticketservice.spring.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @CreateTime 2021-01-01
 * @Author wonzeng
 */
@Configuration
public class ImageConfig {
    public ImageConfig() {
    }
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //最大为3M
        factory.setMaxFileSize(DataSize.ofMegabytes(3L));
        //factory.setMaxFileSize(DataSize.parse("102400KB"));
        //总上传数据大小
        factory.setMaxRequestSize(DataSize.ofGigabytes(1L));
        //factory.setLocation("/var/tmp");
        return factory.createMultipartConfig();
    }
}
