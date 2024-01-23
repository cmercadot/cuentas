package com.cajeroautomatico.cuenta.respository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long nroCuenta;
    private  Long codCliente;
    private  String nombreCuenta;
    private  Double saldoCuenta;
    private  String monedaCuenta;
    private  String estado;
}
