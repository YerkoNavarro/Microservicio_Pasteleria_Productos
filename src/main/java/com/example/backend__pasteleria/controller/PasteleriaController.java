package com.example.backend__pasteleria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend__pasteleria.entity.ProductEntity;
import com.example.backend__pasteleria.model.Producto;
import com.example.backend__pasteleria.service.PasteleriaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
public class PasteleriaController {
    @Autowired
    private PasteleriaService pasteleriaService;

    @PostMapping("/")
    public boolean crearProducto(@RequestBody Producto p){
        return pasteleriaService.crearProducto(p);
    }

    @DeleteMapping("/")
    public boolean eliminarProducto(int id){
        return pasteleriaService.eliminarProducto(id);
    }

    @PutMapping("/")
    public boolean actualizarProducto(@RequestBody Producto p){
        return pasteleriaService.actualizarProducto(p);
    }

    @GetMapping("/")
    public List<ProductEntity> listarProductos(){
        return pasteleriaService.listarProductos();
    }

    @GetMapping("/{id}")
    public ProductEntity buscarProducto(int id){
        return pasteleriaService.buscarProducto(id);
    }


    
}
