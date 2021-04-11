package com.ticketservice.conductor.interfaces;

import com.ticketservice.conductor.domain.entity.ConductorRefund;
import com.ticketservice.conductor.domain.service.ConductorRefundService;
import com.ticketservice.scenic.interfaces.dto.RefundTicketView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @CreateTime 2021-01-03
 * @Author wonzeng
 */
@RestController
@RequestMapping("/conductorRefunds")
@Api(tags="退票信息")
public class ConductorRefundFacade {
    @Autowired
    ConductorRefundService conductorRefundService;
    public ConductorRefundFacade() {
    }
    @PostMapping("/conductorRefund")
    @ApiOperation("添加或修改退票订单")
    public ConductorRefund saveRefundTicket(@RequestBody ConductorRefund conductorRefund){
        return conductorRefundService.saveConductorRefund(conductorRefund);
    }
    @GetMapping("/all")
    @ApiOperation("获取所有退票订单")
    public List<ConductorRefund> getAllConductorRefund(){
        return conductorRefundService.queryAllConductorRefund();
    }

    @GetMapping("/conductorRecordId/{param}")
    @ApiOperation("按售票ID获取退票订单")
    public ConductorRefund getConductorRefundByConductorRecordId(@PathVariable("param") long conductorRecordId){
        return conductorRefundService.queryConductorRefundByConductorRecordId(conductorRecordId);
    }


    @GetMapping("/refundTicketView")
    @ApiOperation("获取退票联合视图：ConductorRefund,ConductorTicketRecord,CustomerVarify")
    public List<RefundTicketView> getRefundTicketView(){
        return conductorRefundService.getAllRefundTicketView();
    }
}
