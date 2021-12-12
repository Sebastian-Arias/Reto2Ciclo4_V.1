package com.Reto2C4.InterfaceCRUD;

import com.Reto2C4.Entity.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Home
 */
public interface OrderInterface extends MongoRepository<Order, Integer> {

    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByzone(final String zone);

    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    //Para buscar el id mayor o descendente 
    Optional<Order> findTopByOrderByIdDesc();
    
  
}
