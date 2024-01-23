package com.cajeroautomatico.cuenta.dto;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class CuentaResponse {

    private  Long nroCuenta;
    private  Long codCliente;
    private  String nombreCuenta;
    private  Double saldoCuenta;
    private  String monedaCuenta;
    private  String estado;
}
