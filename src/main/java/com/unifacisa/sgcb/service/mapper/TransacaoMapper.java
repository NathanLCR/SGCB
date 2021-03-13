package com.unifacisa.sgcb.service.mapper;

import com.unifacisa.sgcb.domain.Transacao;
import com.unifacisa.sgcb.service.dto.TransacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface TransacaoMapper extends EntityMapper<TransacaoDTO, Transacao> {

    @Override
    @Mapping(source = "idConta", target = "conta.id")
    Transacao toEntity(TransacaoDTO dto);

    @Override
    @Mapping(source = "conta.id", target = "idConta")
    TransacaoDTO toDto(Transacao transacao);

}




