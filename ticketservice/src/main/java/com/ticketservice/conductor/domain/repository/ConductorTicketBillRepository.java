package com.ticketservice.conductor.domain.repository;

import com.ticketservice.conductor.domain.entity.ConductorTicketBill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @CreateTime 2020-12-17
 * @Author wonzeng
 */
public interface ConductorTicketBillRepository extends JpaRepository<ConductorTicketBill,Long> {
//    public List<ConductorTicketBill> que
    /**
     * 按照付款人ID(游客）查询账单
     **/
    public List<ConductorTicketBill> queryConductorTicketBillByPayerId(long id);

    /**
     * 按照收款人ID（营业员）查询账单
     **/
    public List<ConductorTicketBill> queryConductorTicketBillByReceiverId(long id);

    /**
     * 按照退票、购票查询账单
     **/
    public List<ConductorTicketBill> queryConductorTicketBillByDealType(String dealType);

}
