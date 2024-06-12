package com.devsu.test.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.test.dto.ClienteDTO;
import com.devsu.test.handlerException.exception.NotFoundException;
import com.devsu.test.model.Cliente;
import com.devsu.test.repository.ClienteRepository;
import com.devsu.test.util.MapeadorCliente;

import jakarta.validation.ValidationException;

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

}
