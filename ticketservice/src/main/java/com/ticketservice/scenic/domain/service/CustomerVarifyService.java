package com.ticketservice.scenic.domain.service;

import com.ticketservice.scenic.domain.entity.CustomerVarify;
import com.ticketservice.scenic.domain.repository.CustomerVerifyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CreateTime 2020-12-12
 * @Author wonzeng
 */
@Slf4j
@Service
public class CustomerVarifyService {
    @Autowired
    CustomerVerifyRepository customerVerifyRepository;

   public List<CustomerVarify> getCustomerVarifyByReamName(String realName){
       log.info("getCustomerVarifyByReamName...realname="+realName);
       return customerVerifyRepository.queryCustomerVarifyByRealName("%"+realName.trim()+"%");
   }

   public List<CustomerVarify> getCustomerVarifyByPhone(String phone){
       log.info("getCustomerVarifyByPhone...phone="+phone);
       return customerVerifyRepository.queryCustomerVarifyByPhone("%"+phone+"%");
   }

   /**
    * 添加登记信息，返回ID
    **/
    public long saveCuctomer(CustomerVarify customerVarify) {
//       long ans = CommonTool.createIdByDateTime();
//       customerVarify.setId(ans);
//       log.info(customerVarify.toString());
       CustomerVarify ans = customerVerifyRepository.save(customerVarify);
       log.info("virifyId="+ans.getId());
       return ans.getId();
    }

    /**
     * 按照ID查找
     **/
    public CustomerVarify findCustomerVarifyById(long id) {
       return customerVerifyRepository.queryCustomerVarifyById(id);
    }
}
