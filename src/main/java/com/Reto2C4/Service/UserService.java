/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto2C4.Service;

import com.Reto2C4.Entity.User;
import com.Reto2C4.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Home
 */
@Service 
public class UserService {
    
    @Autowired 
    private UserRepository UserService;
    
    public List<User> getAll() {
        return UserService.getAll();
    }

    public Optional<User> getUser(int id) {
        return UserService.getUser(id);
    }
    
    public User create(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> e = UserService.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail()) == false) {
                    return UserService.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }
    
    public boolean emailExists(String email) {
        return UserService.emailExists(email);
    }
    
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
    
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            UserService.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = UserService.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
}
