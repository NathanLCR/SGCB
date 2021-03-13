package com.unifacisa.sgcb.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
public class
ContaDTO {

    private Integer id;

    @NotNull
    private Integer idPessoa;

    @NotNull
    private Double limiteSaqueDiario;

    private Boolean flagAtivo = true;

    @NotNull
    private Integer tipoConta;

    private LocalDate dataCriacao;

    private Double saldo;
}
