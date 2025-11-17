package com.example.backend__pasteleria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend__pasteleria.entity.ProductEntity;
import com.example.backend__pasteleria.model.Producto;
import com.example.backend__pasteleria.service.PasteleriaService;

@RestController
public class PasteleriaController {
    @Autowired
    private PasteleriaService pasteleriaService;

    @PostMapping("/")
    public ResponseEntity<Boolean> crearProducto(@RequestBody Producto p){
        if(pasteleriaService.crearProducto(p)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.ok(false);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarProducto(@PathVariable int id){
        if(pasteleriaService.eliminarProducto(id)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.ok(false);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> actualizarProducto(@PathVariable int id, @RequestBody Producto p){
        if(pasteleriaService.actualizarProducto(id, p)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductEntity>> listarProductos(){
        return ResponseEntity.ok(pasteleriaService.listarProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> buscarProducto(@PathVariable int id){
        return ResponseEntity.ok(pasteleriaService.buscarProducto(id));
    }


    
}
