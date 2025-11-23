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
    public boolean crearProducto(Producto p){
        ProductEntity  Entity = new ProductEntity();
           try {
            
            Entity.setNombre(p.getNombre());
            Entity.setPrecio(p.getPrecio());
            Entity.setDescripcion(p.getDescripcion());
            Entity.setImagen(p.getImagen());
            Repository.save(Entity);
            System.out.println("Producto creado exitosamente en la base de datos");
            return true;
           } catch (Exception e) {
            System.out.println("Error al crear el producto");
            return false;
           }
            
        
        
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
