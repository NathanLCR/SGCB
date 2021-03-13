package com.unifacisa.sgcb.builder;

import com.unifacisa.sgcb.domain.Pessoa;
import com.unifacisa.sgcb.repository.PessoaRepository;
import com.unifacisa.sgcb.service.dto.PessoaDTO;
import com.unifacisa.sgcb.service.mapper.PessoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PessoaBuilder  {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private PessoaMapper mapper;

    public Pessoa construirEntidade() {

        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("94028327008");
        pessoa.setDataNascimento(LocalDate.now());
        pessoa.setNome("Usuario");

        return pessoa;
    }

    public Pessoa construirEntidadeEPersistir() {
        Pessoa pessoa = construirEntidade();
        return repository.save(pessoa);
    }

    public PessoaDTO converterParaDto (Pessoa entidade) {
        return mapper.toDto(entidade);
    }
}