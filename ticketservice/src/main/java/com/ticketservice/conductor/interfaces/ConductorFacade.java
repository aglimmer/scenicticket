package com.ticketservice.conductor.interfaces;

import com.ticketservice.conductor.domain.entity.Conductor;
import com.ticketservice.conductor.domain.service.ConductorService;
import com.ticketservice.img.domain.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */
@RestController
@RequestMapping("/conductors")
@Api(tags="营业员信息")
public class ConductorFacade {

    @Autowired
    ConductorService conductorService;

    @Autowired
    ImageService imageService;

    @GetMapping("/{id}")
    @ApiOperation("根据ID获取用户信息")
   public Conductor getConductorById(@PathVariable("id") Long id, HttpServletRequest request){
       return conductorService.queryConductorById(id);
   }


    @PutMapping("/{id}")
    @ApiOperation("根据ID修改用户信息")
   public void saveConductor(@RequestBody Conductor conductor){
        conductorService.saveConductor(conductor);
   }


}
