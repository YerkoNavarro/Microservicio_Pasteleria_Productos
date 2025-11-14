package com.example.backend__pasteleria.entity;

import jakarta.persistence.Column;
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
    @Column
    private String nombre;
    @Column
    private int precio;
    @Column
    private String descripcion;
    @Column
    private String imagen;


}
