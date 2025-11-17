package com.example.backend__pasteleria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Producto {
    
    private Integer id ;
    private String nombre;
    private Integer precio;
    private String descripcion;
    private String imagen;


}
