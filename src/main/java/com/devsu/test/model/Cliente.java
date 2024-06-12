package com.devsu.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cliente")
public class Cliente extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clienteId;
    private String contrasena;
    private Boolean estado;

}
