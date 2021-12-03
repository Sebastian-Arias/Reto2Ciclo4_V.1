/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto2C4.Repository;


import com.Reto2C4.Entity.Laptop;
import com.Reto2C4.InterfaceCRUD.LaptopInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Home
 */
@Repository
public class LaptopRepository {
    
    @Autowired
    private LaptopInterface LaptopCrudRepository;
    
    public List<Laptop> getAll() {
        return LaptopCrudRepository.findAll();
    }

    public Optional<Laptop> getLaptop(int id) {
        return LaptopCrudRepository.findById(id);
    }

    public Laptop create(Laptop computer) {
        return LaptopCrudRepository.save(computer);
    }

    public void update(Laptop computer) {
        LaptopCrudRepository.save(computer);
    }

    public void delete(Laptop computer) {
        LaptopCrudRepository.delete(computer);
    }
}
