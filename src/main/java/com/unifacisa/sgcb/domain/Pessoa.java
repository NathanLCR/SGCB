package com.unifacisa.sgcb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "pessoa")
public class Pessoa implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pessoa")
   @SequenceGenerator(name = "sq_pessoa", allocationSize = 1, sequenceName = "sq_pessoa")
   @Column(name = "id")
   private Integer id;

   @Column(name = "nome")
   private String nome;

   @Column(name = "cpf")
   private String cpf;

   @Column(name = "data_nascimento")
   private LocalDate dataNascimento;
}
