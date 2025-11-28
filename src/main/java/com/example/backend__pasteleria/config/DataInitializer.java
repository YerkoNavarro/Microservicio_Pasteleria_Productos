package com.example.backend__pasteleria.config;

import com.example.backend__pasteleria.entity.ProductEntity;
import com.example.backend__pasteleria.entity.User;
import com.example.backend__pasteleria.repository.ProductRepository;
import com.example.backend__pasteleria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Crear usuario admin si no existe
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setRoles(Set.of(User.Role.ADMIN));
            userRepository.save(admin);
            System.out.println("Usuario admin creado: admin/123456");
        }

        // Crear productos de ejemplo si no existen
        if (productRepository.count() == 0) {
            ProductEntity product1 = new ProductEntity();
            product1.setNombre("Torta Chocolate");
            product1.setPrecio(5000);
            product1.setDescripcion("Deliciosa torta de chocolate con tres leches");
            product1.setImagen("https://via.placeholder.com/300");
            productRepository.save(product1);

            ProductEntity product2 = new ProductEntity();
            product2.setNombre("Torta Fresa");
            product2.setPrecio(4500);
            product2.setDescripcion("Torta de fresa con crema fresca");
            product2.setImagen("https://via.placeholder.com/300");
            productRepository.save(product2);

            ProductEntity product3 = new ProductEntity();
            product3.setNombre("Cheesecake");
            product3.setPrecio(4000);
            product3.setDescripcion("Cheesecake clásico con frutos rojos");
            product3.setImagen("https://via.placeholder.com/300");
            productRepository.save(product3);

            ProductEntity product4 = new ProductEntity();
            product4.setNombre("Brownie");
            product4.setPrecio(2000);
            product4.setDescripcion("Brownie de chocolate con nueces");
            product4.setImagen("https://via.placeholder.com/300");
            productRepository.save(product4);

            ProductEntity product5 = new ProductEntity();
            product5.setNombre("Tiramisú");
            product5.setPrecio(3500);
            product5.setDescripcion("Tiramisú italiano tradicional");
            product5.setImagen("https://via.placeholder.com/300");
            productRepository.save(product5);
            
            System.out.println("5 productos de ejemplo creados");
        }
    }
}
