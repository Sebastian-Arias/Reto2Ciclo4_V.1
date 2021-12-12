package com.Reto2C4;

import com.Reto2C4.InterfaceCRUD.LaptopInterface;
import com.Reto2C4.InterfaceCRUD.OrderInterface;
import com.Reto2C4.InterfaceCRUD.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication //Genere un entorno para spring pueda desplegar servicios web en tomcat
public class Reto2C4Application implements CommandLineRunner{

    @Autowired
    public UserInterface UserRepository;
    
    @Autowired
    public LaptopInterface LaptopRepository;
    
    @Autowired
    public OrderInterface OrderRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(Reto2C4Application.class, args);
	}
        
    @Override
    public void run(String... args) throws Exception {
        UserRepository.deleteAll();
        LaptopRepository.deleteAll();
        OrderRepository.deleteAll();
    }
}
