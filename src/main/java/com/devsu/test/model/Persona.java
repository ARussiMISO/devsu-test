package com.devsu.test.model;

import lombok.Data;

@Data
public class Persona {
    private String nombre;
    private char genero;
    private int  edad;
    private long identificacion;
    private String direccion;
    private String telefono;

}
