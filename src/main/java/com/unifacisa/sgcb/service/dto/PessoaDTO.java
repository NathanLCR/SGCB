package com.unifacisa.sgcb.service.dto;

import com.unifacisa.sgcb.domain.Pessoa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

@Setter
@Getter
public class
PessoaDTO {

    private Integer id;

    private String nome;

    private String cpf;

    private LocalDate dataNascimento;
}
