package com.intercorp.customercare.backend;

import com.intercorp.customercare.backend.controllers.ReclamoController;
import com.intercorp.customercare.backend.dto.ReclamoRequestDto;
import com.intercorp.customercare.backend.services.ReclamoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class ReclamoControllerTest {

    @InjectMocks
    private ReclamoController adminController;
    @Mock
    private ReclamoService reclamoService;


    @Test
    @DisplayName("Return creacionReclamo status when user is created")
    void returnCreacionReclamoStatusWhenUserIsCreated(){
        //Arrange
        ReclamoRequestDto dto = new ReclamoRequestDto();
        //Act
        dto.setDescripcion("Prueba de reclamo");
        dto.setEmpresa("Empresa Prueba");
        Map<String, Boolean> retrunMap = adminController.crearReclamo(dto);
        //Assert
        assertTrue(retrunMap.containsKey("creacionReclamoEstado"));
    }


    @Test
    @DisplayName("Return reclamos list not null when reclamo controller is called")
    void returnReclamosListNotNullWhenReclamoControllerIsCalled(){
        assertNotNull(adminController.listarReclamos());
    }

    @Test
    @DisplayName("Return exception when reclamo id is not valid")
    void returnExceptionWhenReclamoIdIsNotValid(){
        //Arrange
        String id;
        //Act
        id = String.valueOf("a");
        //Assert
        assertThrows(IllegalArgumentException.class,
                ()->{
                    adminController.obtenerReclamoPorCodigo(Integer.valueOf(id));
                });
    }

}
