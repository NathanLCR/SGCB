package com.unifacisa.sgcb.service.mapper;

import com.unifacisa.sgcb.domain.Conta;
import com.unifacisa.sgcb.service.dto.ContaDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface ContaMapper extends EntityMapper<ContaDTO, Conta> {

    @Override
    @Mapping(source = "idPessoa", target = "pessoa.id")
    Conta toEntity(ContaDTO dto);

    @Override
    @Mapping(source = "pessoa.id", target = "idPessoa")
    ContaDTO toDto(Conta conta);

}




