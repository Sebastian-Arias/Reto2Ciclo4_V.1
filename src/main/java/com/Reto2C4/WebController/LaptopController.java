/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto2C4.WebController;

import com.Reto2C4.Entity.Laptop;
import com.Reto2C4.Service.LaptopService;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/laptop")
@CrossOrigin("*")
public class LaptopController {
    
    @Autowired 
    private LaptopService LaptopWeb;

    @GetMapping("/all")
    public List<Laptop> getAll() {
        return LaptopWeb.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Laptop> getLaptop(@PathVariable("id") int id) {
        return LaptopWeb.getLaptop(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop create(@RequestBody Laptop gadget) {
        return LaptopWeb.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop update(@RequestBody Laptop gadget) {
        return LaptopWeb.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return LaptopWeb.delete(id);
    }
    
}
