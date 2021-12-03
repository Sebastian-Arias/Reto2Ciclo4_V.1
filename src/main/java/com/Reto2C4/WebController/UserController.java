package com.Reto2C4.WebController;

import com.Reto2C4.Entity.User;
import com.Reto2C4.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Home
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    
    /**
     * Anotacion para conectarse con los servicios user
     */
    @Autowired
    private UserService UserWeb; // Unused
    
    /**
     * Anotacion para traer toda la informacion 
     * @return 
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return UserWeb.getAll();
    }
    
    /**
     * Anotacion para Ingresar un nuevo usuarioo 
     * @param user
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return UserWeb.create(user);
    }

    /**
     * Anotacion para Actualizar un registro
     * @param user
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return UserWeb.update(user);
    }
    
    /**
     * Anotacion para eliminar por id numerico
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return UserWeb.delete(id);
    }
    
    /**
     * Anotacion para traer toda la informacion por email y password de un usario solo si esta registrado 
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return UserWeb.authenticateUser(email, password);
    }
    
    /**
     * Anotacion para validar si exite un email true si es verdadero false si es falso 
     * @param email
     * @return 
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return UserWeb.emailExists(email);
    }
}
