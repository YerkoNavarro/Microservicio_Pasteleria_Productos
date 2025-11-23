package com.example.backend__pasteleria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend__pasteleria.entity.ProductEntity;
import com.example.backend__pasteleria.model.Producto;
import com.example.backend__pasteleria.service.PasteleriaService;


@RestController
@RequestMapping("/productos")
public class PasteleriaController {
    @Autowired
    private PasteleriaService pasteleriaService;

    @PostMapping("/")
    public boolean crearProducto(@RequestBody Producto p){
        return pasteleriaService.crearProducto(p);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarProducto(int id){
        return pasteleriaService.eliminarProducto(id);
    }

    @PutMapping("/{id}")
    public boolean actualizarProducto(@PathVariable int id, @RequestBody Producto p){
        return pasteleriaService.actualizarProducto(id,p);
    }

    @GetMapping("/")
    public List<ProductEntity> listarProductos(){
        return pasteleriaService.listarProductos();
    }

    @GetMapping("/{id}")
    public ProductEntity buscarProducto(@PathVariable int id){
        return pasteleriaService.buscarProducto(id);
    }


    
}
