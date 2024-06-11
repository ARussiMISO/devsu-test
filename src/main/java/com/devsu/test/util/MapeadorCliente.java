package com.devsu.test.util;

import org.springframework.beans.BeanUtils;

import com.devsu.test.dto.ClienteDTO;
import com.devsu.test.model.Cliente;

public class MapeadorCliente implements Mapeador {

    @Override
    public ClienteDTO mapearEntidadDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();

        BeanUtils.copyProperties(cliente, clienteDTO);

        return clienteDTO;
    }

    @Override
    public Object mapearDTOEntidad(Object dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapearDTOEntidad'");
    }

}
