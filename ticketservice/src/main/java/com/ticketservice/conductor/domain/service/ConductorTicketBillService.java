package com.ticketservice.conductor.domain.service;

import com.ticketservice.conductor.domain.repository.ConductorTicketBillRepository;
import com.ticketservice.conductor.domain.entity.ConductorTicketBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CreateTime 2020-12-17
 * @Author wonzeng
 */
@Service
public class ConductorTicketBillService {
    @Autowired
    ConductorTicketBillRepository conductorTicketBillRepository;
    public ConductorTicketBillService() {
    }
    /**
     * 添加账单
     **/
    public ConductorTicketBill saveTicketBill(ConductorTicketBill conductorTicketBill){
        return conductorTicketBillRepository.save(conductorTicketBill);
    }
    /**
     * 查询所有
     **/
    public List<ConductorTicketBill> getAllTicketBill(){
        return conductorTicketBillRepository.findAll();
    }
    /**
     * 按照付款人ID(游客）查询账单
     **/
    public List<ConductorTicketBill> findConductorTicketBillByPayerId(long id){
        return conductorTicketBillRepository.queryConductorTicketBillByPayerId(id);
    }

    /**
     * 按照收款人ID（营业员）查询账单
     **/
    public List<ConductorTicketBill> findConductorTicketBillByReceiverId(long id){
        return conductorTicketBillRepository.queryConductorTicketBillByReceiverId(id);
    }

    /**
     * 按照退票、购票查询账单
     **/
    public List<ConductorTicketBill> findConductorTicketBillByDealType(String dealType){
        return conductorTicketBillRepository.queryConductorTicketBillByDealType(dealType);
    }
}
