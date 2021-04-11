package com.ticketservice.scenic.domain.service;

import com.ticketservice.img.domain.service.ImageService;
import com.ticketservice.scenic.domain.entity.Scenic;
import com.ticketservice.scenic.domain.entity.ScenicTicket;
import com.ticketservice.scenic.domain.repository.ScenicRepository;
import com.ticketservice.scenic.domain.repository.ScenicTicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-12
 */
@Service
@Slf4j
public class ScenicService {
   @Autowired
   ScenicRepository scenicRepository;

   @Autowired
   ImageService imageService;


   @Autowired
   ScenicTicketRepository scenicTicketRepository;


   private Scenic scenicDTO(Scenic scenic){
       scenic.setScenicImg(imageService.getSecnicImageBaseURL()+"/"+scenic.getScenicImg());
       return scenic;
   }
    /**
     * @Description 查询所有景点
     */
    public List<Scenic> queryAllScenic(){
       return scenicRepository.findAll().stream().map((o)->scenicDTO(o)).collect(Collectors.toList());
    }

    /**
     * @Description 按照景点名称查询，默认按门票费用升序排列
     */
    public List<Scenic> queryByNameAndFeeASC(String scenicName){
        List<Scenic> ans = scenicRepository.queryScenicByScenicNameASC(scenicName);
//        for(int i=0;i<ans.size();i++){
//            log.info(ans.get(i).toString());
//           ans.get(i).setScenicImg(ImageLocation.getSecnicImageBaseURL()+ans.get(i).getScenicName());
//        }
        return ans.stream().map((o)->scenicDTO(o)).collect(Collectors.toList());
    }

    /**
     * @Description 按 ID 查询景点
     */
    public Scenic queryScenicById(long id){
        Scenic scenic =  scenicRepository.queryScenicById(id);
        if(scenic!=null){
            scenic.setScenicImg(imageService.getSecnicImageBaseURL()+scenic.getScenicImg());
        }
        return scenic;
    }

    /**
     * 查询景点门票
     **/
    public List<ScenicTicket> queryScenicTicketById(Long id){

        scenicTicketRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
//        Pageable pageable = PageRequest.of(0,5);
//        scenicTicketRepository.findAll(pageable);

        List<ScenicTicket> tickets =   scenicTicketRepository.queryScenicTicketsByScenicId(id);
        return tickets;
    }
//    public void test() {
        //自定义查询条件
//        Specification<ScenicTicket> spec = new Specification<ScenicTicket>() {
//            @Override
//            public Predicate toPredicate(Root<ScenicTicket> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                                //根据属性名获取查询对象的属性
//                Path<ScenicTicket> path = root.get("receiverName");
//                //相当于 where receiverName = "Veggie", CriteriaBuilder接口中还有很多查询条件，建议看源码
//                Predicate equal = criteriaBuilder.equal(path, "Veggie");
//                return equal;
//            }

//            @Override
//            public Predicate toPredicate(Root<Message> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                //根据属性名获取查询对象的属性
//                Path<Message> path = root.get("receiverName");
//                //相当于 where receiverName = "Veggie", CriteriaBuilder接口中还有很多查询条件，建议看源码
//                Predicate equal = criteriaBuilder.equal(path, "Veggie");
//                return equal;
//            }
//        }
//        //进行条件查询，findAll()方法中的参数即为条件
//        List<ScenicTicket> result = scenicTicketRepository.findAll((Sort) spec);
//    }
    /**
     * 保存
     **/
    public Scenic saveScenic(Scenic scenic){
        log.info(scenic.toString());
        String fileName = imageService.saveBase64Image(scenic.getScenicImg());
        Scenic ans = null;
        if(fileName!=null){
            scenic.setScenicImg(fileName);
            ans = scenicRepository.saveAndFlush(scenic);
            log.info("ID="+ans.getId());
            log.info("saveScenic..."+ans.toString());
        }
        return ans;
    }
    public List<ScenicTicket> saveScenicTicket(List<ScenicTicket> scenicTickets){
        //批量添加数据，如果ScenicTicket实体主键属性ID在数据库中为自增类型，
        // 但是请求参数中又没有给scenicTickets的id指定不同的值时，要进行如下标识为自增属性：
        // @GeneratedValue(strategy = GenerationType.IDENTITY)
        //否则会抛出如下异常
        //A different object with the same identifier value was already associated with the session
        scenicTickets.forEach((obj)->log.info(obj.toString()));
        return scenicTicketRepository.saveAll(scenicTickets);
    }
    public int insertScenicTicket(List<ScenicTicket> scenicTickets){
        int ans = 0;
        for(ScenicTicket obj:scenicTickets){
            log.info(obj.toString()+"--------");
            ans += scenicTicketRepository.insertScenicTicket(obj);
        }
        log.info("ans=",ans);
        return ans;
    }
}
