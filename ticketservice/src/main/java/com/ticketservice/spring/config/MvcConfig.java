package com.ticketservice.spring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ticketservice.spring.interceptor.VisitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    //配置拦截器
//    这里继承接口HandlerInterceptor实现 LoginInterceptor
//    addInterceptor 添加一个拦截器对象new LoginInterceptor
//    addPathPatterns 拦截的 url
//    excludePathPatterns 排除的 url
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("addInterceptors...");
        registry.addInterceptor(new VisitInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/login.html", "/userlogin.con", "/static/**", "/error.html");
    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);

        jackson2HttpMessageConverter.setObjectMapper(objectMapper);
        converters.add(0,jackson2HttpMessageConverter);

    }
//    @Bean
//    public Converter<String, Time> stringToDateConvert() {
//        return new Converter<String, Time>() {
//            @Override
//            public Time convert(String source) {
//                if(source.split(":").length==2){
//                    source +=":00";
//                }
//                Time sdf = Time.valueOf(source);
//                System.out.println("source = " + source);
//                return sdf;
//            }
//        };
//    }


        //配置跨域访问
//      除了这种方式，还可以在配置类中返回FilterRegistrationBean或在拦截器prehandler方法进行配置
//      在 @Configuration注解的配置类中不能使用下面的注解，因为配置类中的方法不依赖于Http请求
//      @Autowired
//      HttpServletRequest request;


}