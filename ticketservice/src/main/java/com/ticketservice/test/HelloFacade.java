package com.ticketservice.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

/**
 * @CreateTime 2021-01-27
 * @Author wonzeng
 */
@RestController
@RequestMapping("/test")
@Slf4j
@Api(tags="测试接口")
public class HelloFacade {
    public HelloFacade() {
    }
    @Data
    public static  class Person{
        private Integer id;
        private String name;
        private Integer age;
        public Person(Integer id,String name,Integer age){
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    @GetMapping("/persons")
    @ApiOperation("接口测试")
    public List<Person> getPersonList(@RequestParam("msg") String param){
        log.info("get----getPersonsList...msg="+param);
        List<Person> persons = new LinkedList<>();
        persons.addAll(Arrays.asList(new Person(101,"xiaozhang",21),new Person(102,"wang",23)));
        return persons;
    }
    @PostMapping("/persons")
    @ApiOperation("接口测试")
    //post请求，需要使用@RequestBody注解，表示接受的是一个post方式发送的请求体
    public List<Person> getPersonList_2(@RequestBody Map<String,Object> obj){
        log.info("post----getPersonsList_2...msg="+obj.get("msg"));
        List<Person> persons = new LinkedList<>();
        persons.addAll(Arrays.asList(new Person(101,"xiaozhang",21),new Person(102,"wang",23)));
        return persons;
    }
}
