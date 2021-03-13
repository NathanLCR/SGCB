package com.unifacisa.sgcb.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PeriodoDTO {
    private LocalDate dataInicial;
    private LocalDate dataFinal;
}
