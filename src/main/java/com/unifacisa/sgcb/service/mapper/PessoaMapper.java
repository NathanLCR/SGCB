package com.unifacisa.sgcb.service.mapper;

import com.unifacisa.sgcb.domain.Conta;
import com.unifacisa.sgcb.domain.Pessoa;
import com.unifacisa.sgcb.service.dto.ContaDTO;
import com.unifacisa.sgcb.service.dto.PessoaDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface PessoaMapper extends EntityMapper<PessoaDTO, Pessoa> {

    @Override
    Pessoa toEntity(PessoaDTO dto);

    @Override
    PessoaDTO toDto(Pessoa pessoa);

}




