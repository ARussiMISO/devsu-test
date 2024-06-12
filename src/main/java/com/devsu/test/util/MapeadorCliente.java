package com.devsu.test.util;

import org.springframework.beans.BeanUtils;

import com.devsu.test.dto.ClienteDTO;
import com.devsu.test.model.Cliente;

public class MapeadorCliente {
 
    public static ClienteDTO mapearEntidadDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();

        BeanUtils.copyProperties(cliente, clienteDTO);

        return clienteDTO;
    }

    public static Cliente mapearDTOEntidad(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();

        BeanUtils.copyProperties(clienteDTO, cliente);

        return cliente;
    }


}
