package com.ticketservice.scenic.domain.repository;

import com.ticketservice.scenic.domain.entity.ScenicTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CreateTime 2020-12-12
 * @Author wonzeng
 */
public interface ScenicTicketRepository extends JpaRepository<ScenicTicket, Long> {
    public List<ScenicTicket> queryScenicTicketsByScenicId(long id);


    @Modifying
    @Transactional
    @Query(value="insert into scenic_ticket(scenic_id,ticket_type,discount_rate)value(:#{#scenicTicket.scenicId},:#{#scenicTicket.ticketType},:#{#scenicTicket.discountRate})",nativeQuery = true)
    public int insertScenicTicket(@Param("scenicTicket") ScenicTicket scenicTicket);

}
