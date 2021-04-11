package com.ticketservice.scenic;

import com.ticketservice.scenic.domain.repository.CustomerVerifyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

/**
 * @CreateTime 2021-01-03
 * @Author wonzeng
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AppTest {


    public class TestParent {

        @Autowired
        protected WebApplicationContext wac;

        @Autowired
        CustomerVerifyRepository customerVerifyRepository;



//        //MVC环境
//        protected MockMvc mockMvc;


//        public void setup() {
//            mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//        }

    }

}
