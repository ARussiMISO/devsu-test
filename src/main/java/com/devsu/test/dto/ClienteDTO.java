package com.devsu.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO extends PersonaDTO{
    private int clienteId;
    private String contrasena;
    private Boolean estado;

}
