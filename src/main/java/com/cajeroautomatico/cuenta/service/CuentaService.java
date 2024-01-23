package com.cajeroautomatico.cuenta.service;

import com.cajeroautomatico.cuenta.dto.CuentaRequest;
import com.cajeroautomatico.cuenta.dto.CuentaResponse;
import com.cajeroautomatico.cuenta.respository.CuentaEntity;
import com.cajeroautomatico.cuenta.respository.CuentaRepository;
import com.cajeroautomatico.cuenta.respository.PageableConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Service
public class CuentaService {
    CuentaRepository cuentaRepository;
    public CuentaService(CuentaRepository cuentaRepository ){
        this.cuentaRepository=cuentaRepository;
    }
    public CuentaResponse createCuenta(CuentaRequest request){
        CuentaEntity cuentaEntity=convertirCuentaRequestCuentaEntity(request);
        return convertirCuentaEntityCuentaResponse(cuentaRepository.save(cuentaEntity));

    }
    public CuentaResponse modificarCuenta(CuentaRequest request){
        Optional<CuentaEntity> optionalCuenta=cuentaRepository.findById(request.getNroCuenta());
        if(optionalCuenta.isPresent()){
            CuentaEntity cuentaEntity=optionalCuenta.get();
            cuentaEntity.setSaldoCuenta(request.getSaldoCuenta());
            return convertirCuentaEntityCuentaResponse(cuentaRepository.save(cuentaEntity));
        }

        return CuentaResponse.builder().build();


    }
    public CuentaResponse findByIdCuenta(Long nroCuenta) {

        Optional<CuentaEntity>  optionalCuenta=cuentaRepository.findById(nroCuenta);
        if(optionalCuenta.isPresent()){
            CuentaEntity cuentaEntity=optionalCuenta.get();
            return convertirCuentaEntityCuentaResponse(cuentaEntity);
        }
        return CuentaResponse.builder().build();
    }
    private CuentaResponse convertirCuentaEntityCuentaResponse(CuentaEntity entity){
        return CuentaResponse.builder()
                .nroCuenta(entity.getNroCuenta())
                .codCliente(entity.getCodCliente())
                .nombreCuenta(entity.getNombreCuenta())
                .saldoCuenta(entity.getSaldoCuenta())
                .monedaCuenta(entity.getMonedaCuenta())
                .estado(entity.getEstado())
                .build();
    }

    private CuentaEntity convertirCuentaRequestCuentaEntity(CuentaRequest request){
        return CuentaEntity.builder()
                .codCliente(request.getCodCliente())
                .nombreCuenta(request.getNombreCuenta())
                .saldoCuenta(request.getSaldoCuenta())
                .monedaCuenta(request.getMonedaCuenta())
                .estado(request.getEstado())
                .build();
    }


    public Page<CuentaResponse> fetchAllPageable(Pageable pageable) {
        Page<CuentaEntity> entityPage=cuentaRepository.findAll(pageable);
        return PageableConverter.castObjectTo(entityPage, this::convertirCuentaEntityCuentaResponse);
    }
}
