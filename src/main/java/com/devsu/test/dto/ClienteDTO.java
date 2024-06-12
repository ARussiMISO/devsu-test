package com.devsu.test.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO extends PersonaDTO{
    @NotBlank(message = "ProductId cannot be blank")
    @Pattern(regexp = "^[0-9]+$", message = "ProductId must contain only numbers")
    private long clienteId;

    @NotBlank(message = "La contraseña no debe estar vacía")
    private String contrasena;
    @NotBlank(message = "El estado no debe estar vacío")
    private Boolean estado;

}
