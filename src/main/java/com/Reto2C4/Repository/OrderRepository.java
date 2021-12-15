package com.Reto2C4.Repository;

import com.Reto2C4.Entity.Order;
import com.Reto2C4.InterfaceCRUD.OrderInterface;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author Home
 */
@Repository
public class OrderRepository {
    
    @Autowired
    private OrderInterface OrderService;
    
    //Reto4 
    @Autowired 
    private MongoTemplate mongotemplate;  // Unused
    
    public List<Order> getAll(){
        return (List<Order>) OrderService.findAll();
    }
    
    public Optional<Order> getOrder(int id){
        return OrderService.findById(id);
    }
    
    public Order create(Order order){
        return OrderService.save(order);
    }
    
    public void update(Order order){
        OrderService.save(order);
    }
    
    public void delete(Order order){
        OrderService.delete(order);
    }
    
    public Optional<Order> lastUserId(){
        return OrderService.findTopByOrderByIdDesc();
    }
    
    public List<Order> findByzone(String zone){
        return OrderService.findByzone(zone);
    }
    
    //Reto4 
    
    //Peticion de las ordenes de un asesor por id
    public List<Order> ordersSalesManByID(Integer id) {
        Query query = new Query();

        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);
        List<Order> orders = mongotemplate.find(query, Order.class);

        return orders;
    }
    
    //Ordenes de un asesor X estado y id 
    public List<Order> ordersSalesManByState(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id).and("status").is(state);
        query.addCriteria(criterio);
        List<Order> orders = mongotemplate.find(query, Order.class);
        return orders;
    }
    
    //Ordenes de un asesor por fecha o el id 
    public List<Order> ordersSalesManByDate(String dateStr, Integer id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);
        query.addCriteria(dateCriteria);
        
        List<Order> orders = mongotemplate.find(query, Order.class);
        return orders;
    }
      
    
    
    
}
