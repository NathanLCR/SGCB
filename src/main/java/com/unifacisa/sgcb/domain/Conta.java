package com.unifacisa.sgcb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "conta")
public class Conta implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_conta")
   @SequenceGenerator(name = "sq_conta", allocationSize = 1, sequenceName = "sq_conta")
   @Column(name = "id")
   private Integer id;

   @OneToOne()
   @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
   private Pessoa pessoa;

   @Column(name = "saldo")
   private Double saldo;

   @Column(name = "limite_saque_diario")
   private Double limiteSaqueDiario;

   @Column(name = "flag_ativo")
   private Boolean flagAtivo;

   @Column(name = "tipo_conta")
   private Integer tipoConta;

   @Column(name = "data_criacao")
   private LocalDate dataCriacao;

   public Conta(){
      this.saldo = 0.00;
      dataCriacao = LocalDate.now();
   }
}
