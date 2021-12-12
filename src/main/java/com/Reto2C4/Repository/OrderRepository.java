package com.Reto2C4.Repository;

import com.Reto2C4.Entity.Order;
import com.Reto2C4.InterfaceCRUD.OrderInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Home
 */
@Repository
public class OrderRepository {
    
    @Autowired
    private OrderInterface OrderService;
    
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
    
}
