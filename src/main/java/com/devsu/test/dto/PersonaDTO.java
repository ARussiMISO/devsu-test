package com.devsu.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaDTO {
    protected String nombre;
    protected char genero;
    protected int  edad;
    protected long identificacion;
    protected String direccion;
    protected String telefono;

}
