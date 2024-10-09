package com.intercorp.customercare.backend.entities.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ReclamoEstadoMaestroEnum {

    PENDIENTE ("Pendiente"),
    EN_REVISION ("En revisión"),
    CERRADA ("Cerrada"),
    ANULADA ("Anulada");

    private String value;

    private ReclamoEstadoMaestroEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    private static final Map<String, ReclamoEstadoMaestroEnum> map = Stream.of(values())
            .collect(Collectors.toMap(ReclamoEstadoMaestroEnum::toString, Function.identity()));

    public static ReclamoEstadoMaestroEnum getReclamoEstado(final String name) {
        ReclamoEstadoMaestroEnum rolEnum = map.get(name);
        if (null == rolEnum) {
            throw new IllegalArgumentException(String.format("'%s' no es un estado valido. Detalle de estados validos: %s", name, Arrays.asList(values())));
        }
        return rolEnum;
    }

}
