package com.ticketservice.conductor.domain.service;

import com.ticketservice.img.domain.service.ImageService;
import com.ticketservice.conductor.domain.entity.Conductor;
import com.ticketservice.conductor.domain.repository.ConductorReposirory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-07
 */
@Service
@Slf4j
public class ConductorService {


    @Autowired
    ConductorReposirory conductorReposirory;
    @Autowired
    ImageService imageService;

    public ConductorService() {
    }

    /**
     * 插入一条营业员记录
     **/
    public Conductor insertConductor(Conductor conductor){
        Conductor ans = conductorReposirory.save(conductor);
        return ans;
    }
    /**
     * 根据ID查询营业员
     **/
    public Conductor queryConductorById(Long id){
        Optional<Conductor> conductor = conductorReposirory.findById(id);
        if(conductor.isPresent()){
            Conductor cs =  conductor.get();
            conductor.get().setProfileImg(imageService.getUserImageBaseURL()+"/"+cs.getProfileImg());
        }
        return conductor.orElse(null);
    }

//    public static void main(String[] args) {
//        String name=null;
//        Optional<String> datas = Optional.ofNullable(name);
//        System.out.println(datas.orElseGet(null));
//    }
    /**
     * 保存信息
     **/
    public Conductor saveConductor(Conductor conductor){
        String img = conductor.getProfileImg();
        img = img.substring(img.lastIndexOf("/")+1);
        conductor.setProfileImg(img);
        return conductorReposirory.save(conductor);
    }

}
