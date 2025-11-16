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
    private ProductRepository productRepository;

    ProductEntity productEntity = new ProductEntity();

    //crud de productos
    public boolean crearProducto(Producto p){
        if (productRepository.existsById(p.getId())) {
            System.out.println("El producto ya existe o el producto es nulo");
            return false;
        }else{
            productEntity.setId(p.getId());
            productEntity.setNombre(p.getNombre());
            productEntity.setPrecio(p.getPrecio());
            productEntity.setDescripcion(p.getDescripcion());
            productEntity.setImagen(p.getImagen());
            productRepository.save(productEntity);
            System.out.println("Producto creado exitosamente en la base de datos");
            return true;
        }
        
    }
    
    @Transactional
    public boolean eliminarProducto(int id){
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            System.out.println("Producto eliminado exitosamente");
            return true;
        }else{
            System.out.println("El producto no existe");
            return false;
        }
    }
    
    
    public boolean actualizarProducto(Producto p){
        if (productRepository.existsById(p.getId())) {
            productEntity.setId(p.getId());
            productEntity.setNombre(p.getNombre());
            productEntity.setPrecio(p.getPrecio());
            productEntity.setDescripcion(p.getDescripcion());
            productEntity.setImagen(p.getImagen());
            productRepository.save(productEntity);
            System.out.println("Producto actualizado exitosamente");
            return true;
        }else{
            System.out.println("El producto no existe");
            return false;
        }
    }    

    public List<ProductEntity> listarProductos(){
        return productRepository.findAll();
    }

    public ProductEntity buscarProducto(int id){
        return productRepository.findById(id).orElse(null);
    }
}
