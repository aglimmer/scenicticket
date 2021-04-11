package com.ticketservice.spring.config;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    //    创建多个swagger文档分组
    @Bean
    public Docket docketB(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("Group-B");
    }
    @Bean
    public Docket docketC(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("Group-C");
    }


    //    该方法返回Docket对象，是Swagger核心的bean，进行一些重要配置，可以使用多个方法返回多个这样的实例
//    Environment对象读取配置文件中的spring.profiles.active指定的值，由spring进行注入，由此可动态控制是否启用swagger文档
    @Bean
    public Docket docket(/*Environment env*/) {
        System.out.println("swagger-ui-------------------------------");
//        设置要显示的swagger环境
//        Profiles prof = Profiles.of("dev","test");
//        如果激活的环境与Profiles指定的环境一致返回true
//        boolean flag = env.acceptsProfiles(prof);
          boolean flag = true;
//        enable为true，表示启动swagger，此时可以在浏览器中访问
//        RequestHandlerSelectors 选择要扫描的范围
//        RequestHandlerSelectors.basePackage("com.controller")  扫描指定的包
//        RequestHandlerSelectors.withMethodAnnotation(GetMapping.class) 指定方法上的注解
//        RequestHandlerSelectors.withClassAnnotation(Controller.class) 指定类上的注解
//        paths(PathSelectors.regex("/swagger/*")) 指定的正则表达式路径
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Group-A")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ticketservice"))
//                .paths(PathSelectors.regex("/swagger/*"))
                .build();
    }
    //   返回一个ApiInfo实例，配置了文档的一些基本信息Docket实例需要用到
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("景点门票API接口")
                .description("swagger接口测试描述信息")
                .version("v-1.0")
                .termsOfServiceUrl("https://mp.csdn.net/console/article")
                .contact(new Contact("wonzeng", "https://mp.csdn.net/console/article", "222xxxxx@qq.com"))
                .license("swagger-lisense-0.0")
                .build();
    }
}
