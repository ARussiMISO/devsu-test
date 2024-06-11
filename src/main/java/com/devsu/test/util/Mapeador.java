package com.devsu.test.util;

public interface Mapeador<E,D> {

    D mapearEntidadDTO (E entidad);
    E mapearDTOEntidad(D dto);

}
