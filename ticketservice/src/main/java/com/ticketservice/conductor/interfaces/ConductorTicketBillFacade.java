package com.ticketservice.conductor.interfaces;

import com.ticketservice.conductor.domain.service.ConductorTicketBillService;
import com.ticketservice.conductor.domain.entity.ConductorTicketBill;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @CreateTime 2020-12-17
 * @Author wonzeng
 */
@RestController
@RequestMapping("/ticketBills")
@Api(tags="售票账单信息")
public class ConductorTicketBillFacade {
    @Autowired
    ConductorTicketBillService conductorTicketBillService;
    public ConductorTicketBillFacade() {
    }

    @PostMapping("/add")
    @ApiOperation("添加账单")
    public ConductorTicketBill addTicketBill(ConductorTicketBill conductorTicketBill){
        return conductorTicketBillService.saveTicketBill(conductorTicketBill);
    }

    /**
     * 查询所有
     **/
    @GetMapping("/all")
    @ApiOperation("查询所有")
    public List<ConductorTicketBill> getAllTicketBill(){
        return conductorTicketBillService.getAllTicketBill();
    }
    /**
     * 按照付款人ID(游客）查询账单
     **/
    @GetMapping("/payerId/{param}")
    @ApiOperation("查询所有")
    public List<ConductorTicketBill> getConductorTicketBillByPayerId(@PathVariable("param") long id){
        return conductorTicketBillService.findConductorTicketBillByPayerId(id);
    }

    /**
     * 按照收款人ID（营业员）查询账单
     **/
    @GetMapping("/receiverId/{param}")
    @ApiOperation("按照ID查询")
    public List<ConductorTicketBill> findConductorTicketBillByReceiverId(@PathVariable("param") long id){
        return conductorTicketBillService.findConductorTicketBillByReceiverId(id);
    }

    /**
     * 按照退票、购票查询账单
     **/
    @GetMapping("/dealType/{param}")
    @ApiOperation("按照ID查询")
    public List<ConductorTicketBill> findConductorTicketBillByDealType(@PathVariable("param") String dealType){
        return conductorTicketBillService.findConductorTicketBillByDealType(dealType);
    }
}
