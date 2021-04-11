package com.ticketservice.conductor.domain.repository;

import com.ticketservice.conductor.domain.entity.ConductorRefund;
import com.ticketservice.scenic.interfaces.dto.RefundTicketView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @CreateTime 2021-01-03
 * @Author wonzeng
 */
public interface ConductorRefundRepository extends JpaRepository<ConductorRefund,Long> {
    public ConductorRefund findConductorRefundByConductorRecordId(Long conductorRecordId);


    @Query(value="select new com.ticketservice.scenic.interfaces.dto.RefundTicketView(A,B,C) from ConductorRefund A,CustomerVarify B,ConductorTicketRecord C where " +
            "A.conductorRecordId=C.id and C.varifyId=B.id")
    public List<RefundTicketView> queryRefundTicketView();

}

