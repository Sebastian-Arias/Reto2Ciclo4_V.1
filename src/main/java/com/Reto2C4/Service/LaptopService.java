package com.Reto2C4.Service;

import com.Reto2C4.Entity.Laptop;
import com.Reto2C4.Repository.LaptopRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Home
 */
@Service
public class LaptopService {
    
    @Autowired 
    private LaptopRepository LaptopService;
    
    //Reto3
    @Autowired
    private MongoTemplate mongotemplate;
    
    public List<Laptop> getAll() {
        return LaptopService.getAll();
    }

    public Optional<Laptop> getLaptop(int id) {
        return LaptopService.getLaptop(id);
    }
    
    public Laptop create(Laptop computer) {
        if (computer.getId() == null) {
            return computer;
        } else {
            return LaptopService.create(computer);
        }
    }

    public Laptop update(Laptop laptop) {

        if (laptop.getId() != null) {
            Optional<Laptop> updateCrud = LaptopService.getLaptop(laptop.getId());
            if (!updateCrud.isEmpty()) {

                if (laptop.getBrand() != null) {
                    updateCrud.get().setBrand(laptop.getBrand());
                }
                if (laptop.getModel() != null) {
                    updateCrud.get().setModel(laptop.getModel());
                }
                if (laptop.getProcesor() != null) {
                    updateCrud.get().setProcesor(laptop.getProcesor());
                }
                if (laptop.getOs() != null) {
                    updateCrud.get().setOs(laptop.getOs());
                }
                if (laptop.getDescription() != null) {
                    updateCrud.get().setDescription(laptop.getDescription());
                }
                if (laptop.getMemory() != null) {
                    updateCrud.get().setMemory(laptop.getMemory());
                }
                if (laptop.getHardDrive() != null) {
                    updateCrud.get().setHardDrive(laptop.getHardDrive());
                }
                if (laptop.getPrice() != 0.0) {
                    updateCrud.get().setPrice(laptop.getPrice());
                }
                if (laptop.getQuantity() != 0) {
                    updateCrud.get().setQuantity(laptop.getQuantity());
                }
                if (laptop.getPhotography() != null) {
                    updateCrud.get().setPhotography(laptop.getPhotography());
                }
                updateCrud.get().setAvailability(laptop.isAvailability());
                LaptopService.update(updateCrud.get());
                return updateCrud.get();
            } else {
                return laptop;
            }
        } else {
            return laptop;
        }
    }
   
    public boolean delete(int userId) {
        Boolean aBoolean = getLaptop(userId).map( laptop -> {
            LaptopService.delete(laptop);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    //METODOS RETO5 MIRAR LAS MODIFICACIONES
        public List<Laptop> findByPrice(double price) {
        return LaptopService.findByPrice(price);
    }
    
    private boolean checkStrings(String string1, String string2) {
        return string1.contains(string2);  //VAMOS A MIRAR
    }
    
    public List<Laptop> findByDescription(String description2) {
        List<Laptop> product = LaptopService.getAll();
        ArrayList<Laptop> product2 = new ArrayList();
        product.forEach(LaptopProduc -> {  //VAMOS A MIRAR
            String descripcion1 = LaptopProduc.getDescription();
            if (checkStrings(descripcion1, description2)) {
                product2.add(LaptopProduc);
            }
        });
        return (List<Laptop>) product2;
    }
    
}
