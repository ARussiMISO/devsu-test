package com.devsu.test.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaDTO {
    @NotBlank(message = "El nombre no debe estar vacío")
    @Size(max = 100, message = "El nombre debe tener máximo 100 caracteres")
    protected String nombre;

    @NotBlank(message = "El nombre no debe estar vacío")
    @Size(min=1, max = 1, message = "El género debe tener 1 caracter")
    protected char genero;

    @NotBlank(message = "La edad no debe estar vacía")
    @Positive(message = "La edad debe ser mayor que cero")
    protected int  edad;

    @NotBlank(message = "La identificación no debe estar vacía")
    @Positive(message = "La identificación debe ser mayor que cero")
    protected long identificacion;

    @NotBlank(message = "La direccion no debe estar vacía")
    @Size(max = 100, message = "La direccion debe tener máximo 100 caracteres")
    protected String direccion;

    @NotBlank(message = "El teléfono no debe estar vacío")
    @Size(max = 100, message = "El teléfono debe tener máximo 20 caracteres")
    protected String telefono;

}
