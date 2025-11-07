package com.example.backend__pasteleria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity {
    
    @Id
    private int id ;
    private String nombre;
    private int precio;
    private String descripcion;
    private String imagen;


}
