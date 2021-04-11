package com.ticketservice.conductor.domain.service;

import com.ticketservice.conductor.domain.entity.ConductorTicketRecord;
import com.ticketservice.conductor.domain.repository.ConductorTickerRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @CreateTime 2020-12-17
 * @Author wonzeng
 */
@Service
@Slf4j
public class ConductorTicketRecordService {
    @Autowired
    ConductorTickerRecordRepository conductorTickerRecordRepository;
    public ConductorTicketRecordService() {
    }

    /**
     * 按ID查询订单
     **/
    public ConductorTicketRecord findConductorTicketRecordById(long id){
        return conductorTickerRecordRepository.queryConductorTicketRecordById(id);
    }

    /**
     * 保存售票订单
     **/
    public ConductorTicketRecord saveConductorTicket(ConductorTicketRecord conductorTicketRecord){
        return conductorTickerRecordRepository.save(conductorTicketRecord);
    }

    /**
     * 按照用户ID查询订单
     **/
    public List<ConductorTicketRecord> findConductorTicketRecordByVarifyId(long varifyId){
        log.info("findConductorTicketRecordByVarifyId.........");
        List<ConductorTicketRecord> ans =  conductorTickerRecordRepository.queryConductorTicketRecordByVarifyId(varifyId);
        ans.forEach((name)->log.info(name.toString()));
        return ans;
    }

    /**
     * 按照使用门票日期查询
     **/
    public List<ConductorTicketRecord> findConductorTicketRecordByOrderDate(Date orderDate){
        return conductorTickerRecordRepository.queryConductorTicketRecordByOrderDate(orderDate);
    }

    /**
     * 修改为退票状态
     **/
    public int setDealNote(long id){
        return conductorTickerRecordRepository.updateDealNote(id);
    }

    /**
     * 按照景点ID查询订单
     **/
    public List<ConductorTicketRecord> findConductorTicketRecordByScenicId(long scenicId){
        return conductorTickerRecordRepository.queryConductorTicketRecordByScenicId(scenicId);
    }

    /**
     * 按照营业员ID查询订单
     **/
    public List<ConductorTicketRecord> findConductorTicketRecordByConductorId(long conductorId){
        return conductorTickerRecordRepository.queryConductorTicketRecordByConductorId(conductorId);
    }



}
