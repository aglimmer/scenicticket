package com.ticketservice.scenic.domain.repository;

import com.ticketservice.scenic.domain.entity.CustomerVarify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @CreateTime 2020-12-12
 * @Author wonzeng
 */
public interface CustomerVerifyRepository extends JpaRepository<CustomerVarify,Long> {

    /**
     * 按照游客姓名查找
     **/
    @Query(value="select id,real_name,id_number,phone from customer_varify where real_name like ? ",nativeQuery = true)
    public List<CustomerVarify> queryCustomerVarifyByRealName(String realName);

    /**
     * 按照手机号查找
     **/
    @Query(value="select id,real_name,id_number,phone from customer_varify where phone like ? ",nativeQuery = true)
    public List<CustomerVarify> queryCustomerVarifyByPhone(String phone);

    /**
     * 按照Id查找
     **/
    public CustomerVarify queryCustomerVarifyById(long id);

    @Query(value="select A.id as customer_id,A.real_name,B.id as refund_id,B.refund_size,B.refund_money,B.refund_date,B.conductor_record_id from customer_varify A,conductor_refund B,conductor_ticket_record C where "+
            "B.conductor_record_id=C.id and C.varify_id=A.id",nativeQuery = true)
    public List<Map<String,Object>> queryRefundTicket();



}
