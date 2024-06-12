package com.devsu.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.test.dto.ClienteDTO;
import com.devsu.test.handlerException.dto.ExceptionMessage;
import com.devsu.test.handlerException.exception.NotFoundException;
import com.devsu.test.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/clientes")
@Validated

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation( summary = "Obtener cliente por id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description =  "Cliente con id existe", content = @Content(schema = @Schema(implementation = ClienteDTO.class))),
        @ApiResponse(responseCode = "404", description =  "Cliente con id no existe", content = @Content(schema = @Schema(implementation = ExceptionMessage.class)))
    })
    @GetMapping( value = "/{clienteId}", produces = "application/json")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable @NotBlank String clienteId) throws NotFoundException{
        return ResponseEntity.ok(this.clienteService.obtenerCliente(clienteId));
    }

    @Operation( summary = "Obtener todos los clientes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description =  "Clientes existentes", content = @Content(schema = @Schema(implementation = ClienteDTO.class))),
        @ApiResponse(responseCode = "404", description =  "No existen clientes", content = @Content(schema = @Schema(implementation = ExceptionMessage.class)))
    })
    @GetMapping( value = "/all", produces = "application/json")
    public ResponseEntity<List<ClienteDTO>> obtenerTodosClientes() throws NotFoundException{
        return ResponseEntity.ok(this.clienteService.obtenerTodosClientes());
    }

    



}
