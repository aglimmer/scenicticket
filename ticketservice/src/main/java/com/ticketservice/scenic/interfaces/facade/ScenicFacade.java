package com.ticketservice.scenic.interfaces.facade;

import com.ticketservice.scenic.domain.service.ScenicService;
import com.ticketservice.scenic.domain.entity.Scenic;
import com.ticketservice.scenic.domain.entity.ScenicTicket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-12
 */
@RestController
@RequestMapping("/scenics")
@Api(tags = "景点信息")
public class ScenicFacade {
    @Autowired
   ScenicService scenicService;


    /**
     * 查询所有景点
     **/
    @GetMapping("/all")
    @ApiOperation("查询所有景点")
    public List<Scenic> queryAllScenic(){
        return scenicService.queryAllScenic();
    }

    /**
     * 按id查询景点
     **/
    @GetMapping("/id/{param}")
    @ApiOperation("查询具体景点")
    public Scenic queryScenicById(@PathVariable("param") long id){
        return scenicService.queryScenicById(id);
    }

    /**
     * 按景点名称查询景点
     **/
    @GetMapping("/scenicName/{param}")
    @ApiOperation("模糊查询景点")
    public List<Scenic> queryScenicByScenicName(@PathVariable("param") String scenicName){
        return scenicService.queryByNameAndFeeASC("%"+scenicName+"%");
    }

    /**
     * 按景点id查询门票
     **/
    @GetMapping("/scenicId/{param}")
    @ApiOperation("查询具体景点")
    public List<ScenicTicket> queryScenicTicketByScenicId(@PathVariable("param") long id){
       return scenicService.queryScenicTicketById(id);
    }

    @PostMapping("/scenic")
    @ApiOperation("添加或修改景点")
    public Scenic updateScenic(@RequestBody Scenic scenic){
        System.out.println("scenic = " + scenic);
        return scenicService.saveScenic(scenic);
    }
    @PostMapping("/scenicTicket")
    @ApiOperation("添加或修改门票")
    public List<ScenicTicket> updateScenicTicket(@RequestBody List<ScenicTicket> scenicTickets){
        return scenicService.saveScenicTicket(scenicTickets);
    }

}
