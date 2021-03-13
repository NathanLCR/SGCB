package com.unifacisa.sgcb.builder;

import com.unifacisa.sgcb.domain.Conta;
import com.unifacisa.sgcb.domain.Pessoa;
import com.unifacisa.sgcb.domain.Transacao;
import com.unifacisa.sgcb.repository.ContaRepository;
import com.unifacisa.sgcb.repository.TransacaoRepository;
import com.unifacisa.sgcb.service.mapper.ContaMapper;
import com.unifacisa.sgcb.service.mapper.TransacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransacaoBuilder {

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private TransacaoMapper mapper;

    @Autowired
    private ContaBuilder contaBuilder;

    public Transacao construirEntidade() {
        Transacao transacao = new Transacao();
        Conta conta = contaBuilder.construirEntidadeEPersistir();
        transacao.setConta(conta);
        transacao.setValor(100.00);
        return transacao;
    }

    public Transacao persistir() {
        Transacao transacao = construirEntidade();
        return repository.save(transacao);
    }
    
}