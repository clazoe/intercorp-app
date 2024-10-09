package com.intercorp.customercare.backend.util;

import com.intercorp.customercare.backend.entities.ReclamoMotivo;
import com.intercorp.customercare.backend.entities.enums.ReclamoMotivoEnum;
import com.intercorp.customercare.backend.repositories.ReclamoMotivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Component
public class ClaimDetailLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ReclamoMotivoRepository reclamoMotivoRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.loadRoReclamoMotivo();
    }

    private void loadRoReclamoMotivo() {
        ReclamoMotivoEnum[] reaclamoMotivos = new ReclamoMotivoEnum[] { ReclamoMotivoEnum.FECHA_ENTREGA_INCUMPLIDA,
                                                                        ReclamoMotivoEnum.PRODUCTO_CON_DEFECTOS,
                                                                        ReclamoMotivoEnum.PROBLEMAS_CON_PERSONAL};
        Map<ReclamoMotivoEnum, String> roleDescriptionMap = Map.of(
                ReclamoMotivoEnum.FECHA_ENTREGA_INCUMPLIDA, ReclamoMotivoEnum.FECHA_ENTREGA_INCUMPLIDA.getValue(),
                ReclamoMotivoEnum.PRODUCTO_CON_DEFECTOS, ReclamoMotivoEnum.PRODUCTO_CON_DEFECTOS.getValue(),
                ReclamoMotivoEnum.PROBLEMAS_CON_PERSONAL, ReclamoMotivoEnum.PROBLEMAS_CON_PERSONAL.getValue()
        );

        Arrays.stream(reaclamoMotivos).forEach((reaclamoMotivo) -> {
            Optional<ReclamoMotivo> optionalReclamoMotivo = reclamoMotivoRepository.findByNombre(reaclamoMotivo);

            optionalReclamoMotivo.ifPresentOrElse(System.out::println, () -> {
                ReclamoMotivo reclamoMotivo = new ReclamoMotivo();

                reclamoMotivo.setNombre(reaclamoMotivo);
                reclamoMotivo.setDescripcion(roleDescriptionMap.get(reaclamoMotivo));


                reclamoMotivoRepository.save(reclamoMotivo);
            });
        });
    }
}
