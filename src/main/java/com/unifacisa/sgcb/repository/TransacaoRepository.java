package com.unifacisa.sgcb.repository;

import com.unifacisa.sgcb.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Integer> {

    @Query("SELECT t "+
            "FROM Transacao t " +
            "JOIN t.conta c " +
            "WHERE t.dataTransacao >= :dataInicial and t.dataTransacao <= :dataFinal and c.id = :idConta"
    )
    List<Transacao> extratoPorPeriodo (@Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal, @Param("idConta") Integer idConta);

    List<Transacao> findAllByContaId (Integer id);
}
