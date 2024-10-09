package com.intercorp.customercare.backend.entities.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ReclamoMotivoEnum {
    FECHA_ENTREGA_INCUMPLIDA ("Fecha de Entrega Incumplida"),
    PRODUCTO_CON_DEFECTOS ("Producto con Defectos"),
    PROBLEMAS_CON_PERSONAL ("Problemas con Personal");


    private String value;

    private ReclamoMotivoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    private static final Map<String, ReclamoMotivoEnum> map = Stream.of(values())
            .collect(Collectors.toMap(ReclamoMotivoEnum::toString, Function.identity()));

    public static ReclamoMotivoEnum getClaimDetail(final String name) {
        ReclamoMotivoEnum rolEnum = map.get(name);
        if (null == rolEnum) {
            throw new IllegalArgumentException(String.format("'%s' no es un detalle de reclamo valido. Detalle de reclamos validos: %s", name, Arrays.asList(values())));
        }
        return rolEnum;
    }


}
