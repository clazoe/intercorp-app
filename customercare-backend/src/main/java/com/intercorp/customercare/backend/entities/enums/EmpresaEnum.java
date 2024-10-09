package com.intercorp.customercare.backend.entities.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EmpresaEnum {
    Promart,
    Oeschle,
    plazaVea,
    Vivanda;

    private static final Map<String, EmpresaEnum> map = Stream.of(values())
            .collect(Collectors.toMap(EmpresaEnum::toString, Function.identity()));

    public static EmpresaEnum getEmpresaDetail(final String name) {
        EmpresaEnum empresaEnum = map.get(name);
        if (null == empresaEnum) {
            throw new IllegalArgumentException(String.format("'%s' no es una empresa valida. Empresas validas: %s", name, Arrays.asList(values())));
        }
        return empresaEnum;
    }


}
