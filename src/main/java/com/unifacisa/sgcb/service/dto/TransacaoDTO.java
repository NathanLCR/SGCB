package com.unifacisa.sgcb.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Setter
@Getter
public class
TransacaoDTO {

    private Integer id;

    @NotNull
    private Integer idConta;

    @NotNull
    @PositiveOrZero
    private Double valor;

    private LocalDate dataTransacao;
}
