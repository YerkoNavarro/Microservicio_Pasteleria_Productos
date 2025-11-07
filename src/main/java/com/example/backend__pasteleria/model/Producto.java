package com.example.backend__pasteleria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Producto {
    
    private int id ;
    private String nombre;
    private int precio;
    private String descripcion;
    private String imagen;


}
