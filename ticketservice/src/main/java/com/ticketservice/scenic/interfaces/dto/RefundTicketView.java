package com.ticketservice.scenic.interfaces.dto;

import com.ticketservice.conductor.domain.entity.ConductorRefund;
import com.ticketservice.conductor.domain.entity.ConductorTicketRecord;
import com.ticketservice.scenic.domain.entity.CustomerVarify;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @CreateTime 2021-01-03
 * @Author wonzeng
 */
@Setter
@Getter
@ToString
//@NoArgsConstructor
@Slf4j
public class RefundTicketView {

    private ConductorRefund conductorRefund;
    private CustomerVarify customerVarify;
    private ConductorTicketRecord conductorTicketRecord;

    public RefundTicketView(ConductorRefund conductorRefund, CustomerVarify customerVarify, ConductorTicketRecord conductorTicketRecord) {
        System.out.println("conductorRefund = " + conductorRefund + ", customerVarify = " + customerVarify + ", conductorTicketRecord = " + conductorTicketRecord);
        this.conductorRefund = conductorRefund;
        this.customerVarify = customerVarify;
        this.conductorTicketRecord = conductorTicketRecord;
    }

    public ConductorRefund getConductorRefund() {
        return conductorRefund;
    }

    public void setConductorRefund(ConductorRefund conductorRefund) {
        System.out.println("conductorRefund = " + conductorRefund);
        this.conductorRefund = conductorRefund;
        this.conductorTicketRecord = new ConductorTicketRecord();
        this.customerVarify = new CustomerVarify();
    }

    public CustomerVarify getCustomerVarify() {
        return customerVarify;
    }

    public void setCustomerVarify(CustomerVarify customerVarify) {
        System.out.println("customerVarify = " + customerVarify);
        this.conductorTicketRecord = new ConductorTicketRecord();
        this.conductorRefund = new ConductorRefund();
        this.customerVarify = customerVarify;
    }

    public ConductorTicketRecord getConductorTicketRecord() {
        return conductorTicketRecord;
    }

    public void setConductorTicketRecord(ConductorTicketRecord conductorTicketRecord) {
        System.out.println("conductorTicketRecord = " + conductorTicketRecord);
        this.customerVarify = new CustomerVarify();
        this.conductorRefund = new ConductorRefund();
        this.conductorTicketRecord = conductorTicketRecord;
    }


    //    public RefundTicketDao(double refundMoney, long customerId, String realName, int refundSize, Timestamp refundDate, long conductorRecordId) {
//        this.refundMoney = refundMoney;
//        this.customerId = customerId;
//        this.realName = realName;
//        this.refundSize = refundSize;
//        this.refundDate = refundDate;
//        this.conductorRecordId = conductorRecordId;
//    }



}
