package com.ticketservice.conductor.domain.repository;

import com.ticketservice.conductor.domain.entity.ConductorTicketRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

/**
 * @CreateTime 2020-12-17
 * @Author wonzeng
 */
public interface ConductorTickerRecordRepository extends JpaRepository<ConductorTicketRecord,Long> {
//    public void saveConductorTicketRecord(ConductorTickerRecord conductorTickerRecord)

    /**
     * 按照Id查询订单
     **/
    public ConductorTicketRecord queryConductorTicketRecordById(long id);
    /**
     * 按照用户ID查询订单
     **/
    public List<ConductorTicketRecord> queryConductorTicketRecordByVarifyId(long varifyId);

    /**
     * 按照使用门票日期查询
     **/
    public List<ConductorTicketRecord> queryConductorTicketRecordByOrderDate(Date orderDate);

    /**
     * 修改为退票状态
     **/
    @Query(value="update conductor_ticket_record set deal_note='退票' where id=1",nativeQuery =true)
    @Modifying
    public int updateDealNote(long id);

    /**
     * 按照景点ID查询订单
     **/
    public List<ConductorTicketRecord> queryConductorTicketRecordByScenicId(long scenicId);

    /**
     * 按照营业员ID查询订单
     **/
    public List<ConductorTicketRecord> queryConductorTicketRecordByConductorId(long conductorId);


}
