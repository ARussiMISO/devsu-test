package com.devsu.test.util;

@FunctionalInterface
public interface MapeadorEntidadDTO<E,D> {

    public D mapear (E entidad);

}
