package com.Reto2C4.Service;

import com.Reto2C4.Entity.User;
import com.Reto2C4.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sebastian Arias
 * Anotacion de la clase service
 */
@Service 
public class UserService {
    
    /**
     * Anotacion con el UserRepository
     */
    @Autowired 
    private UserRepository UserService; // Unused
    
    /**
     * Anotacion Para traer los usuarios
     * @return 
     */
    public List<User> getAll() {                
        return UserService.getAll();
    }
    
    /**
     * Anotacion para traer un usuario por su ID 
     * @param primaryKey
     * @return 
     */
    public Optional<User> getUser(int primaryKey) {       
        return UserService.getUser(primaryKey);
    }
    
    /**
     * Anotacion para crear los usuarios dependiendo de la informacion del id u email si esten creado o no
     * @param user
     * @return 
     */
    public User create(User user) {
        Optional<User> userIdMaximo = UserService.lastUserId();
        if (user.getId() == null) {
            if (userIdMaximo.isEmpty()) {
                user.setId(1);
            } else {
                user.setId(userIdMaximo.get().getId() + 1);
            }
        }
        Optional<User> evento = UserService.getUser(user.getId());
        if (evento.isEmpty()) {
            if (emailExists(user.getEmail()) == false) {
                return UserService.create(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    /**
     * Verificas si un email ya existe en la coleccion de mongo 
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        return UserService.emailExists(email);
    }
    
    /**
     * Metodo para actualizar
     * @param user
     * @return 
     */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> updateCrud = UserService.getUser(user.getId());
            if (!updateCrud.isEmpty()) {

                if (user.getIdentification() != null) {
                    updateCrud.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    updateCrud.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    updateCrud.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    updateCrud.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    updateCrud.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    updateCrud.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    updateCrud.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    updateCrud.get().setType(user.getType());
                }
                UserService.update(updateCrud.get());
                return updateCrud.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    /**
     * Metodo para eliminar por medio de un id 
     * @param userId
     * @return 
     */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            UserService.delete(user);
            return true;
        }).orElse(false);  // instead, just 'return doSomething();'
        return aBoolean;
    }
    
    /**
     * Metodo para autentificar un usuario 
     * @param email
     * @param password
     * @return 
     */
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = UserService.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    
    
    
    //RETO5 No hace parte de nuebas practicas para el reto4
    public List<User> findByMonthBirthtDay(String birthday) {
        return UserService.findByMonthBirthtDay(birthday);
    }
}
