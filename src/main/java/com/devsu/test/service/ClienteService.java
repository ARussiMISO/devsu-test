package com.devsu.test.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.test.dto.ClienteDTO;
import com.devsu.test.handlerException.exception.AlreadyExistsException;
import com.devsu.test.handlerException.exception.NotFoundException;
import com.devsu.test.model.Cliente;
import com.devsu.test.repository.ClienteRepository;
import com.devsu.test.util.MapeadorCliente;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.NotBlank;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO obtenerCliente(String clienteId) throws NotFoundException {
        if (StringUtils.isNumeric(clienteId) && !clienteId.isBlank()) {
            Cliente clienteEncontrado = this.clienteRepository.findById(Long.parseLong(clienteId))
                    .orElseThrow(() -> new NotFoundException("Cliente no encontrado"));

            return MapeadorCliente.mapearEntidadDTO(clienteEncontrado);
        } else {
            throw new ValidationException("ClienteId invalido");
        }
    }

    public List<ClienteDTO> obtenerTodosClientes() throws NotFoundException {
       List<Cliente> clientesEncontrados = this.clienteRepository.findAll();

       if(clientesEncontrados.isEmpty())
            throw new NotFoundException("No hay registros de clientes");
       else
        return clientesEncontrados.stream().map(cliente -> MapeadorCliente.mapearEntidadDTO(cliente)).toList();
        
    }

    public ClienteDTO crearCliente(ClienteDTO clienteDTO) throws AlreadyExistsException {
        if(this.clienteRepository.findById(clienteDTO.getClienteId()).isPresent())
            throw new AlreadyExistsException("Cliente ya existe");
        
        Cliente clienteNuevo = this.clienteRepository.save(MapeadorCliente.mapearDTOEntidad(clienteDTO));
        return MapeadorCliente.mapearEntidadDTO(clienteNuevo);
    }

    public ClienteDTO actualizarCliente(ClienteDTO clienteDTO) throws NotFoundException {
        Cliente clienteEncontrado = this.clienteRepository.findById(clienteDTO.getClienteId())
                    .orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
        
        Cliente clienteActualizado = this.clienteRepository.save(clienteEncontrado);

        return MapeadorCliente.mapearEntidadDTO(clienteActualizado);

    }

    public void eliminarCliente(String clienteId) throws NotFoundException {
        Cliente clienteEncontrado = this.clienteRepository.findById(Long.parseLong(clienteId))
        .orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
        this.clienteRepository.delete(clienteEncontrado);

    }

}
