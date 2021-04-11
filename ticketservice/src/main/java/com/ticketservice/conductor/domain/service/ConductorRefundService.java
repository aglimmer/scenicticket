package com.ticketservice.conductor.domain.service;

import com.ticketservice.conductor.domain.entity.ConductorRefund;
import com.ticketservice.conductor.domain.repository.ConductorRefundRepository;
import com.ticketservice.scenic.interfaces.dto.RefundTicketView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CreateTime 2021-01-03
 * @Author wonzeng
 */
@Service
@Slf4j
public class ConductorRefundService {
    @Autowired
    ConductorRefundRepository conductorRefundRepository;
    public ConductorRefundService() {
    }

    public ConductorRefund saveConductorRefund(ConductorRefund conductorRefund){
        log.info("saveConductorRefund...");
        log.info(conductorRefund.toString());
        return conductorRefundRepository.save(conductorRefund);
    }

    public List<ConductorRefund> queryAllConductorRefund(){
        return conductorRefundRepository.findAll();
    }
    public ConductorRefund queryConductorRefundByConductorRecordId(long conductorRecordId){
        log.info("conductorRecordId="+conductorRecordId);
        return conductorRefundRepository.findConductorRefundByConductorRecordId(conductorRecordId);
    }

    public List<RefundTicketView> getAllRefundTicketView(){
        return conductorRefundRepository.queryRefundTicketView();
    }


}
