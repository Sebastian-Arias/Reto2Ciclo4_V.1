package com.Reto2C4.InterfaceCRUD;

import com.Reto2C4.Entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Home
 */
public interface UserInterface extends MongoRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    
    //Reto 3 Para buscar el id mayor o descendente 
    Optional<User> findTopByOrderByIdDesc();
    
    //Reto5 Buscar por mes de nacimiento
    public List <User> findByMonthBirthtDay (String birthday);
}
