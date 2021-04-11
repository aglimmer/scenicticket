package com.ticketservice.scenic;

import com.ticketservice.scenic.domain.entity.CustomerVarify;
import com.ticketservice.conductor.domain.repository.ConductorRefundRepository;
import com.ticketservice.scenic.interfaces.dto.RefundTicketView;
import com.ticketservice.scenic.domain.repository.CustomerVerifyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class TicketserviceApplicationTests {

    @Autowired
    CustomerVerifyRepository customerVerifyRepository;

    @Autowired
    ConductorRefundRepository conductorRefundRepository;


//    @Test
    public void testCustomer(){
        long id = 20210103004107285L;
        CustomerVarify obj = customerVerifyRepository.queryCustomerVarifyById(id);
        log.info(obj.toString());
    }
//    @After
//    @Test
    public void contextLoads() {
        List<Map<String,Object>> dao = customerVerifyRepository.queryRefundTicket();
        dao.forEach((o)->{
            o.forEach((name,value)->{
                System.out.println(name+"="+value);
            });
        });
    }
    @Test
    public void testQuery(){
        List<RefundTicketView> dao = conductorRefundRepository.queryRefundTicketView();
        dao.forEach((o)->{
            System.out.println(o.getConductorRefund());
            System.out.println(o.getConductorTicketRecord());
            System.out.println(o.getCustomerVarify());
        });

    }
}
