/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto2C4.Repository;

import com.Reto2C4.Entity.User;
import com.Reto2C4.InterfaceCRUD.UserInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Home
 */
@Repository
public class UserRepository {
        
    @Autowired
    private UserInterface UserCrudRepository;
    
    public List<User> getAll() {
        return (List<User>) UserCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return  UserCrudRepository.findById(id);
    }
    
    public User create(User user) {
        return UserCrudRepository.save(user);
    }

    public void update(User user) {
        UserCrudRepository.save(user);
    }

    public void delete(User user) {
        UserCrudRepository.delete(user);
    }
    
    public boolean emailExists(String email) {
        Optional<User> usuario = UserCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return UserCrudRepository.findByEmailAndPassword(email, password);
    }
}
