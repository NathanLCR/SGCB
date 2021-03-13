package com.unifacisa.sgcb.service;


import com.unifacisa.sgcb.domain.Transacao;
import com.unifacisa.sgcb.repository.TransacaoRepository;
import com.unifacisa.sgcb.service.dto.PeriodoDTO;
import com.unifacisa.sgcb.service.dto.TransacaoDTO;
import com.unifacisa.sgcb.service.mapper.TransacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class TransacaoService {

    private final TransacaoRepository repository;

    private final TransacaoMapper mapper;

    private final ContaServico contaServico;

    private static final Double MULTIPLICADOR_SAQUE = -1.00;

    private static final Double MULTIPLICADOR_DEPOSITO = 1.00;

    private TransacaoDTO criarTransacao (TransacaoDTO transacaoDTO, Double multiplicador){
        contaServico.realizaTransacao(transacaoDTO.getIdConta(), multiplicador * transacaoDTO.getValor());
        Transacao transacao = repository.save(mapper.toEntity(transacaoDTO));
        return mapper.toDto(transacao);
    }

    public TransacaoDTO depositar (TransacaoDTO transacaoDTO){
        return criarTransacao(transacaoDTO, MULTIPLICADOR_DEPOSITO);
    }

    public TransacaoDTO sacar (TransacaoDTO transacaoDTO){
        return criarTransacao(transacaoDTO, MULTIPLICADOR_SAQUE);
    }

    public List<TransacaoDTO> extrato (Integer idConta){
        return mapper.toDto(repository.findAllByContaId(idConta));
    }

    public List<TransacaoDTO> extratoPorPeriodo (PeriodoDTO periodo, Integer idConta){
        return mapper.toDto(repository.extratoPorPeriodo(periodo.getDataInicial(), periodo.getDataFinal(), idConta));
    }

}
