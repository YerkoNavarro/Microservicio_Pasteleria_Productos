package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.backend__pasteleria.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
    UserEntity findByIdUserEntity(int idUsuario);
    Boolean existsByIdUserEntity(int idUsuario);
    void deleteByIdUserEntity(int idUsuario);
    
}
