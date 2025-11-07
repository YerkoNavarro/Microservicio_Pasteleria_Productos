package com.example.backend__pasteleria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class Cliente {
    private int id;
    private String address;
    private String mail;
    private String password;

}



