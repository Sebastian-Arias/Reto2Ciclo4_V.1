package com.Reto2C4.Service;

import com.Reto2C4.Entity.Order;
import com.Reto2C4.Repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Home
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository OrderService;
    
    public List<Order> getAll() {
        return OrderService.getAll();
    }
    
    public Optional<Order> getOrder(int id) {
        return OrderService.getOrder(id);
    }
    
    public Order create(Order order) {

        //obtiene el maximo id existente en la coleccion
        Optional<Order> orderIdMaxima = OrderService.lastUserId();

        //si el id de la orden que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (order.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (orderIdMaxima.isEmpty()) {
                order.setId(1);
            } //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo de la orden
            else {
                order.setId(orderIdMaxima.get().getId() + 1);
            }
        }

        Optional<Order> e = OrderService.getOrder(order.getId());
        if (e.isEmpty()) {
            return OrderService.create(order);
        } else {
            return order;
        }
    }
    
    public Order update(Order order){
        
        if(order.getId() != null){
            Optional<Order> orderdb = OrderService.getOrder(order.getId());
            if(!orderdb.isEmpty()){
                
                if(order.getStatus() != null){
                    orderdb.get().setStatus(order.getStatus());
                }
                OrderService.update(orderdb.get());
                return orderdb.get();
            }else{
                return order;
            }  
        } else{
             return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            OrderService.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List<Order> findByZone(String zone) {
        return OrderService.findByzone(zone);
    }                    
        
}
