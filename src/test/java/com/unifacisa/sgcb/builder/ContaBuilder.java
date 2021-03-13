package com.unifacisa.sgcb.builder;

import com.unifacisa.sgcb.domain.Conta;
import com.unifacisa.sgcb.domain.Pessoa;
import com.unifacisa.sgcb.repository.ContaRepository;
import com.unifacisa.sgcb.repository.PessoaRepository;
import com.unifacisa.sgcb.service.dto.PessoaDTO;
import com.unifacisa.sgcb.service.mapper.ContaMapper;
import com.unifacisa.sgcb.service.mapper.PessoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ContaBuilder {

    @Autowired
    private ContaRepository repository;

    @Autowired
    private PessoaBuilder pessoaBuilder;

    public Conta construirEntidade() {
        Conta conta = new Conta();
        Pessoa pessoa = pessoaBuilder.construirEntidadeEPersistir();
        conta.setLimiteSaqueDiario(100.00);
        conta.setPessoa(pessoa);
        conta.setTipoConta(1);
        conta.setFlagAtivo(true);
        conta.setDataCriacao(LocalDate.now());
        conta.setSaldo(0.00);
        return conta;
    }

    public Conta construirEntidadeEPersistir() {
        Conta conta = construirEntidade();
        return repository.save(conta);
    }

}