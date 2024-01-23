package com.cajeroautomatico.cuenta.controller;

import com.cajeroautomatico.cuenta.dto.CuentaRequest;
import com.cajeroautomatico.cuenta.dto.CuentaResponse;
import com.cajeroautomatico.cuenta.service.CuentaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/v1/cuenta")
@RestController
public class CuentaApi {


    CuentaService cuentaService;
    public CuentaApi(CuentaService cuentaService){
        this.cuentaService=cuentaService;
    }
    @PostMapping
    public ResponseEntity<CuentaResponse> createCuenta(@RequestBody CuentaRequest request){
        return ResponseEntity.ok(cuentaService.createCuenta(request));
    }
    @PutMapping
    public ResponseEntity<CuentaResponse> modificarCuenta(@RequestBody CuentaRequest request){
        return ResponseEntity.ok(cuentaService.modificarCuenta(request));
    }
    @GetMapping
    public Page<CuentaResponse> fetchPageableCuenta(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return  cuentaService.fetchAllPageable(pageable);

    }

    @GetMapping("{nroCuenta}")
    public ResponseEntity<CuentaResponse> findByIdCuenta(@PathVariable Long nroCuenta) {
       return     ResponseEntity.ok(cuentaService.findByIdCuenta(nroCuenta));

    }


}
