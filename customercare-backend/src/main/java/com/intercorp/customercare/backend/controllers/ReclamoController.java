package com.intercorp.customercare.backend.controllers;

import com.intercorp.customercare.backend.dto.ReclamoEstadoDto;
import com.intercorp.customercare.backend.dto.ReclamoRequestDto;
import com.intercorp.customercare.backend.dto.ReclamoResponseDto;
import com.intercorp.customercare.backend.services.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequestMapping("/claims")
@RestController
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;

    @PostMapping
    public Map<String, Boolean> crearReclamo(@RequestBody ReclamoRequestDto reclamoRequestDto) {
        reclamoService.crearReclamoEstado(reclamoRequestDto);
        return Collections.singletonMap("creacionReclamoEstado", true);
    }

    @GetMapping
    public ResponseEntity<List<ReclamoResponseDto>> listarReclamos() {
        List <ReclamoResponseDto> reclamos = reclamoService.getReclamos();
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReclamoResponseDto> obtenerReclamoPorCodigo(@PathVariable Integer id) {
        ReclamoResponseDto reclamo = reclamoService.getReclamoById(id);
        return ResponseEntity.ok(reclamo);
    }


    @PostMapping("/{id}/status")
    public Map<String, Boolean> actualizarEstadoReclamoPorCodigo(@PathVariable Integer id, @RequestBody ReclamoEstadoDto reclamoEstadoDto ) {
        reclamoService.actualizarEstadoReclamoPorCodigo(id,reclamoEstadoDto);
        return Collections.singletonMap("actualizaReclamoEstado", true);
    }
}
