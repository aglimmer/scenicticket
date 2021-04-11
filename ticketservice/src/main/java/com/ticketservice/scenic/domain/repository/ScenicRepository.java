package com.ticketservice.scenic.domain.repository;

import com.ticketservice.scenic.domain.entity.Scenic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-12
 */
public interface ScenicRepository extends JpaRepository<Scenic,Long> {
    public List<Scenic> queryScenicByScenicName(String scenicName);

    @Query(value="select * from scenic where scenic_name like ? order by fee asc",nativeQuery = true)
    public List<Scenic> queryScenicByScenicNameASC(String scenicName);

//    @Query(value="")
//    public int insertScenic(@Path("scenic") Scenic scenic);

    public Scenic queryScenicById(long id);




}
