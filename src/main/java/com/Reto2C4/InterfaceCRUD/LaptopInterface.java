package com.Reto2C4.InterfaceCRUD;

import com.Reto2C4.Entity.Laptop;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Home
 */
public interface LaptopInterface extends MongoRepository<Laptop, Integer>{
    public List<Laptop> findByPrice (double price);
}
