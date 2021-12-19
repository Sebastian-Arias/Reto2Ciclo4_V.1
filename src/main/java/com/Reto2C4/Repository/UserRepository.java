package com.Reto2C4.Repository;

import com.Reto2C4.Entity.User;
import com.Reto2C4.InterfaceCRUD.UserInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *@author Sebastian Arias
 *Anotacion para indicarle a la clase que sera un repositorio
 */
@Repository
public class UserRepository {
    
    /**
     * Anotacion con la clase del CRUD userInterface
     */    
    @Autowired
    private UserInterface UserCrudRepository; // Unused
    
    /**
     * Metodo para traerme todos los usuarios
     * @return 
     */
    public List<User> getAll() {
        return (List<User>) UserCrudRepository.findAll();
    }
    
    /**
     * Metodo para traerme a un usuario por su id de tipo entero 
     * @param Primaryid
     * @return 
     */
    public Optional<User> getUser(int Primaryid) {
        return  UserCrudRepository.findById(Primaryid);
    }
    
    /**
     * Metodo para Crear un usuario 
     * @param user
     * @return 
     */
    public User create(User user) {
        return UserCrudRepository.save(user);
    }
    
    /**
     * Metodo para actualizar un usuario
     * @param user 
     */
    public void update(User user) {
        UserCrudRepository.save(user);
    }
    
    /**
     * Metodo para eliminar un usuario
     * @param user 
     */
    public void delete(User user) {
        UserCrudRepository.delete(user);
    }
    
    /**
     * Metodo para verificar si un email ya existe 
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = UserCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    
    /**
     * Metodo para traer la informacion de un usuario por su email y contraseña
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> authenticateUser(String email, String password) {
        return UserCrudRepository.findByEmailAndPassword(email, password);
    }
    
    /**
     * Reto3
     * Metodo para traerme toda la informacion de un usuario por su id numerico
     * @return 
     */
    public Optional<User> lastUserId(){
        return UserCrudRepository.findTopByOrderByIdDesc();
    }
    
    /**
     * Reto5
     * Metodo para buscar a un usuario por su mes de nacimiento
     * @param birthday
     * @return 
     */
    public List<User> findByMonthBirthtDay(String birthday) {
        return UserCrudRepository.findByMonthBirthtDay(birthday);
    }
}
