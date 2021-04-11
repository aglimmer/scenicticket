package com.ticketservice.conductor.domain.repository;

import com.ticketservice.conductor.domain.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-07
 */

public interface ConductorReposirory extends JpaRepository<Conductor,Long> {
//    public List<Conductor> findConductorByIdOrderByRegisterTimeAsc();
//    public List<Conductor> findConductorByRealnamelike(String naem);
}
