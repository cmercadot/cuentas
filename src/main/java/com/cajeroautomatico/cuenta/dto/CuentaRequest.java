package com.cajeroautomatico.cuenta.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaRequest {
    @Schema(title = "Numero de cuenta del cliente",
            description = "Dejar 0, el sistema retona el numero de cuenta nuevo",
            example = "1000")
    private  Long nroCuenta;
    private  Long codCliente;
    private  String nombreCuenta;
    private  Double saldoCuenta;
    private  String monedaCuenta;
    private  String estado;
}
