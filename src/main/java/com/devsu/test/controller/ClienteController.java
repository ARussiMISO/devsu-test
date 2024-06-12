package com.devsu.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.test.dto.ClienteDTO;
import com.devsu.test.handlerException.dto.ExceptionMessage;
import com.devsu.test.handlerException.exception.AlreadyExistsException;
import com.devsu.test.handlerException.exception.NotFoundException;
import com.devsu.test.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/clientes")
@Validated

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Obtener cliente por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente con id existe", content = @Content(schema = @Schema(implementation = ClienteDTO.class))),
            @ApiResponse(responseCode = "404", description = "Cliente con id no existe", content = @Content(schema = @Schema(implementation = ExceptionMessage.class)))
    })
    @GetMapping(value = "/{clienteId}", produces = "application/json")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable @NotBlank String clienteId)
            throws NotFoundException {
        return ResponseEntity.ok(this.clienteService.obtenerCliente(clienteId));
    }

    @Operation(summary = "Obtener todos los clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientes existentes", content = @Content(schema = @Schema(implementation = ClienteDTO.class))),
            @ApiResponse(responseCode = "404", description = "No existen clientes", content = @Content(schema = @Schema(implementation = ExceptionMessage.class)))
    })
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<ClienteDTO>> obtenerTodosClientes() throws NotFoundException {
        return ResponseEntity.ok(this.clienteService.obtenerTodosClientes());
    }

    @Operation(summary = "Crear cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado", content = @Content(schema = @Schema(implementation = ClienteDTO.class))),
            @ApiResponse(responseCode = "409", description = "Cliente ya existe", content = @Content(schema = @Schema(implementation = ExceptionMessage.class))),
            @ApiResponse(responseCode = "400", description =  "El cliente tiene atributos invalidos", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody  @Valid ClienteDTO clienteDTO) throws AlreadyExistsException {
        return new ResponseEntity<>(this.clienteService.crearCliente(clienteDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente actualizado", content = @Content(schema = @Schema(implementation = ClienteDTO.class))),
            @ApiResponse(responseCode = "404", description = "No existe cliente para actualizar", content = @Content(schema = @Schema(implementation = ExceptionMessage.class)))
    })
    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ClienteDTO> actualizarCliente(@RequestBody  @Valid ClienteDTO clienteDTO) throws AlreadyExistsException, NotFoundException {
        return ResponseEntity.ok(this.clienteService.actualizarCliente(clienteDTO));
    }

    @Operation(summary = "Eliminar cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente eliminado", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "No existe cliente para eliminar", content = @Content(schema = @Schema(implementation = ExceptionMessage.class)))
    })
    @DeleteMapping(value = "/{clienteId}", produces = "application/json")
    public ResponseEntity<String> eliminarCliente(@PathVariable @NotBlank String clienteId) throws NotFoundException {
        this.clienteService.eliminarCliente(clienteId);
        return new ResponseEntity<>("Cliente eliminado", HttpStatus.NO_CONTENT);

    }



}
