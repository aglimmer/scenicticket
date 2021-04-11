package com.ticketservice.conductor.interfaces;

import com.ticketservice.conductor.domain.entity.ConductorTicketRecord;
import com.ticketservice.conductor.domain.service.ConductorTicketRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 * @CreateTime 2020-12-17
 * @Author wonzeng
 */
@Api(tags="营业员售票信息")
@RestController
@RequestMapping("/conductorTicketRecords")
public class ConductorTicketRecordFacade {
    @Autowired
    ConductorTicketRecordService conductorTicketRecordService;

    @ApiOperation("按照订单ID查询订单")
    @GetMapping("/id/{param}")
    public ConductorTicketRecord getConductorTicketRecordById(long id){
        return conductorTicketRecordService.findConductorTicketRecordById(id);
    }

    /**
     * 按照用户ID查询订单
     **/
    @ApiOperation("按照用户ID查询订单")
    @GetMapping("/varifyId/{param}")
    public List<ConductorTicketRecord> getConductorTicketRecordByVarifyId(@PathVariable("param") long varifyId){
        List<ConductorTicketRecord> ans =  conductorTicketRecordService.findConductorTicketRecordByVarifyId(varifyId);
        ans.forEach((obj)-> System.out.println("getConductorTicketRecordByVarifyId = " + obj));
        return ans;
    }

    /**
     * 按照使用门票日期查询
     **/
    @ApiOperation("按照使用门票日期查询")
    @GetMapping("/orderDate/{param}")
    public List<ConductorTicketRecord> getConductorTicketRecordByOrderDate(@PathVariable("param") Date orderDate){
        return conductorTicketRecordService.findConductorTicketRecordByOrderDate(orderDate);
    }

    /**
     * 修改为退票状态
     **/
    @ApiOperation("修改为退票状态")
    @PutMapping("/record")
    public int setDealNote(long id){
        return conductorTicketRecordService.setDealNote(id);
    }

    /**
     * 按照景点ID查询订单
     **/
    @ApiOperation("按照景点ID查询订单")
    @PutMapping("/scenicId/{param}")
    public List<ConductorTicketRecord> getConductorTicketRecordByScenicId(@PathVariable("param") long scenicId){
        return conductorTicketRecordService.findConductorTicketRecordByScenicId(scenicId);
    }

    /**
     * 按照营业员ID查询订单
     **/
    @ApiOperation("按照营业员ID查询订单")
    @PutMapping("/conductorId/{param}")
    public List<ConductorTicketRecord> getConductorTicketRecordByConductorId(@PathVariable("param") long conductorId){
        return conductorTicketRecordService.findConductorTicketRecordByConductorId(conductorId);
    }

    @ApiOperation("保存售票订单")
    @PostMapping("/record")
    public ConductorTicketRecord saveConductorTicket(@RequestBody ConductorTicketRecord conductorTicketRecord){
        return conductorTicketRecordService.saveConductorTicket(conductorTicketRecord);
    }
}
