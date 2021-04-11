package com.ticketservice.scenic.interfaces.facade;

import com.ticketservice.scenic.domain.entity.CustomerVarify;
import com.ticketservice.scenic.domain.service.CustomerVarifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @CreateTime 2020-12-12
 * @Author wonzeng
 */
@RestController
@RequestMapping("/customerVarifys")
@Api(tags="游客登记信息")
public class CustomerVarifyFacade {
    @Autowired
    CustomerVarifyService customerVarifyService;

    @ApiOperation("按ID查询")
    @PostMapping("/id/{param}")
    public CustomerVarify getCustomerVarifyById(@PathVariable("param") long id){
        return customerVarifyService.findCustomerVarifyById(id);
    }

    @ApiOperation("添加登记的游客")
    @PostMapping("/add")
    public long saveCustomerVirify(@RequestBody CustomerVarify customerVarify){
        long ans =  customerVarifyService.saveCuctomer(customerVarify);
        System.out.println("saveCustomerVirify...id = " + ans);
        return ans;
    }

    @ApiOperation("按姓名查找登记的游客")
    @GetMapping("/realName/{param}")
    public List<CustomerVarify> getCustomerVarifyByReamName(@PathVariable("param") String realName){
        return customerVarifyService.getCustomerVarifyByReamName(realName);
    }

    @ApiOperation("按手机号查找登记的游客")
    @GetMapping("/phone/{param}")
    public List<CustomerVarify> getCustomerVarifyByPhone(@PathVariable("param") String phone){
        return customerVarifyService.getCustomerVarifyByPhone(phone);
    }

}
