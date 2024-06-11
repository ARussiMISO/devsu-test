package com.devsu.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.test.dto.ClienteDTO;
import com.devsu.test.handlerException.exception.NotFoundException;
import com.devsu.test.service.ClienteService;

import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/clientes")
@Validated

public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    @GetMapping( value = "/{clienteId}", produces = "application/json")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable @NotBlank int clienteId) throws NotFoundException{
        return ResponseEntity.ok();
    }

}
