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
@Table(name = "transacao")
public class Transacao implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_transacao")
   @SequenceGenerator(name = "sq_transacao", allocationSize = 1, sequenceName = "sq_transacao")
   @Column(name = "id")
   private Integer id;

   @OneToOne()
   @JoinColumn(name = "id_conta", referencedColumnName = "id")
   private Conta conta;

   @Column(name = "valor")
   private Double valor;

   @Column(name = "data_transacao")
   private LocalDate dataTransacao;

   public Transacao(){
      this.dataTransacao = LocalDate.now();
   }
}
