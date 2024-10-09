package com.intercorp.customercare.backend.services;

import com.intercorp.customercare.backend.dto.ReclamoEstadoDto;
import com.intercorp.customercare.backend.dto.ReclamoRequestDto;
import com.intercorp.customercare.backend.dto.ReclamoResponseDto;
import com.intercorp.customercare.backend.dto.mapper.AdjuntoMapper;
import com.intercorp.customercare.backend.dto.mapper.ReclamoResponseMapper;
import com.intercorp.customercare.backend.entities.*;
import com.intercorp.customercare.backend.entities.enums.EmpresaEnum;
import com.intercorp.customercare.backend.entities.enums.ReclamoEstadoMaestroEnum;
import com.intercorp.customercare.backend.entities.enums.ReclamoMotivoEnum;
import com.intercorp.customercare.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReclamoService {
    @Autowired
    private ReclamoMotivoRepository reclamoMotivoRepository;
    @Autowired
    private ReclamoRepository reclamoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private AdjuntoMapper adjuntoMapper;
    @Autowired
    private ReclamoEstadoMaestroRepository reclamoEstadoMaestroRepository;
    @Autowired
    private ReclamoEstadoRepository reclamoEstadoRepository;
    @Autowired
    private ReclamoResponseMapper reclamoResponseMapper;


    private Reclamo getReclamo(ReclamoRequestDto input){
        Reclamo reclamo = new Reclamo();
        Optional<Empresa> optionalEmpresa = empresaRepository
                .findByNombreEmpresa(EmpresaEnum.getEmpresaDetail(input.getEmpresa()));
        reclamo.setEmpresa(optionalEmpresa.orElseThrow(() -> new RuntimeException("Empresa Invalida")));
        reclamo.setDescripcion(input.getDescripcion());
        Optional<ReclamoMotivo> optionalClaimDetail = reclamoMotivoRepository
                .findByNombre(ReclamoMotivoEnum.getClaimDetail(input.getReclamoMotivo()));
        reclamo.setReclamoMotivo(optionalClaimDetail.orElseThrow(() -> new RuntimeException("Detalle invalido")));
        reclamo.setAdjuntos(adjuntoMapper.toEntity(input.getAdjuntos()));
        reclamo.setCorreoCliente(input.getCorreoCliente());
        return reclamo;
    }

    private ReclamoEstado getReclamoEstado(ReclamoRequestDto input){
        ReclamoEstadoDto reclamoEstadoDto = input.getReclamoEstado();
        ReclamoEstado reclamoEstado = new ReclamoEstado();
        Optional<ReclamoEstadoMaestro> optionalEstadoMaestro = reclamoEstadoMaestroRepository
                .findByNombreEstado(ReclamoEstadoMaestroEnum.getReclamoEstado(reclamoEstadoDto.getEstado()));
        reclamoEstado.setReclamoEstadoMaestro(optionalEstadoMaestro.orElseThrow(() -> new RuntimeException("Estado del reclamo invalido")));
        reclamoEstado.setCorreoAsesor(reclamoEstadoDto.getCorreoAsesor());
        reclamoEstado.setComentarioAsesor(reclamoEstadoDto.getComentarioAsesor());
        return reclamoEstado;
    }


    public Reclamo crearReclamoEstado (ReclamoRequestDto input){
        Reclamo reclamo = getReclamo(input);
        reclamo.setReclamoEstado(getReclamoEstado(input));
        return reclamoRepository.save(reclamo);
    }

    public List<ReclamoResponseDto> getReclamos() {
        List<Reclamo> reclamos = new ArrayList<>();
        reclamoRepository.findAll().forEach(reclamos::add);
        return reclamos.stream().map(reclamoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    public ReclamoResponseDto getReclamoById(Integer id) {
        Optional<Reclamo> reclamo = reclamoRepository.findById(id);
        return reclamoResponseMapper.toDto(reclamo.orElseThrow(()->new RuntimeException("No se encontro reclamo: " + id)));
    }

    @Transactional
    public void actualizarEstadoReclamoPorCodigo(Integer id, ReclamoEstadoDto reclamoEstadoDto) {
        ReclamoEstado reclamoEstado = reclamoEstadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Estado del reclamo no encontrado"));
        Optional<ReclamoEstadoMaestro> optionalEstadoMaestro = reclamoEstadoMaestroRepository
                .findByNombreEstado(ReclamoEstadoMaestroEnum.getReclamoEstado(reclamoEstadoDto.getEstado()));
        reclamoEstado.setCorreoAsesor(reclamoEstadoDto.getCorreoAsesor());
        reclamoEstado.setComentarioAsesor(reclamoEstadoDto.getComentarioAsesor());
        reclamoEstado.setReclamoEstadoMaestro(optionalEstadoMaestro.orElseThrow(() -> new RuntimeException("Estado del reclamo invalido")));
        reclamoEstadoRepository.save(reclamoEstado);
    }
}
