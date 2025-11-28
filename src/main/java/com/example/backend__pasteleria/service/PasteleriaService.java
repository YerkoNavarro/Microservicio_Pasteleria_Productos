package com.example.backend__pasteleria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend__pasteleria.model.Producto;
import com.example.backend__pasteleria.repository.ProductRepository;

import jakarta.transaction.Transactional;

import com.example.backend__pasteleria.entity.ProductEntity;

@Service
public class PasteleriaService {
    @Autowired 
    private ProductRepository Repository;

    

    //crud de productos
    public ProductEntity crearProducto(Producto p){
        ProductEntity  Entity = new ProductEntity();
        Entity.setNombre(p.getNombre());
        Entity.setPrecio(p.getPrecio());
        Entity.setDescripcion(p.getDescripcion());
        Entity.setImagen(p.getImagen());
        ProductEntity savedEntity = Repository.save(Entity);
        return savedEntity;
    }
    
    @Transactional
    public boolean eliminarProducto(int id){
        if (Repository.existsById(id)) {
            Repository.deleteById(id);
            System.out.println("Producto eliminado exitosamente");
            return true;
        }else{
            System.out.println("El producto no existe");
            return false;
        }
    }
    
    
    public boolean actualizarProducto(int id,Producto p){
        ProductEntity Entity = new ProductEntity();
        if (Repository.existsById(id)) {
            Entity.setId(id);
            Entity.setNombre(p.getNombre());
            Entity.setPrecio(p.getPrecio());
            Entity.setDescripcion(p.getDescripcion());
            Entity.setImagen(p.getImagen());
            Repository.save(Entity);
            System.out.println("Producto actualizado exitosamente");
            return true;
        }else{
            System.out.println("El producto no existe");
            return false;
        }
    }    

    public List<ProductEntity> listarProductos(){
        return Repository.findAll();
    }

    public ProductEntity buscarProducto(int id){
        return Repository.findById(id).orElse(null);
    }
}
