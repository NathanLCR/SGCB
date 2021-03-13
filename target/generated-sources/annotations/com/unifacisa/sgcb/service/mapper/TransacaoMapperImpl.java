package com.unifacisa.sgcb.service.mapper;

import com.unifacisa.sgcb.domain.Conta;
import com.unifacisa.sgcb.domain.Transacao;
import com.unifacisa.sgcb.service.dto.TransacaoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-12T21:40:08-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_282 (Private Build)"
)
@Component
public class TransacaoMapperImpl implements TransacaoMapper {

    @Override
    public List<Transacao> toEntity(List<TransacaoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Transacao> list = new ArrayList<Transacao>( dtoList.size() );
        for ( TransacaoDTO transacaoDTO : dtoList ) {
            list.add( toEntity( transacaoDTO ) );
        }

        return list;
    }

    @Override
    public List<TransacaoDTO> toDto(List<Transacao> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TransacaoDTO> list = new ArrayList<TransacaoDTO>( entityList.size() );
        for ( Transacao transacao : entityList ) {
            list.add( toDto( transacao ) );
        }

        return list;
    }

    @Override
    public Transacao toEntity(TransacaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Transacao transacao = new Transacao();

        transacao.setConta( transacaoDTOToConta( dto ) );
        transacao.setId( dto.getId() );
        transacao.setValor( dto.getValor() );
        transacao.setDataTransacao( dto.getDataTransacao() );

        return transacao;
    }

    @Override
    public TransacaoDTO toDto(Transacao transacao) {
        if ( transacao == null ) {
            return null;
        }

        TransacaoDTO transacaoDTO = new TransacaoDTO();

        transacaoDTO.setIdConta( transacaoContaId( transacao ) );
        transacaoDTO.setId( transacao.getId() );
        transacaoDTO.setValor( transacao.getValor() );
        transacaoDTO.setDataTransacao( transacao.getDataTransacao() );

        return transacaoDTO;
    }

    protected Conta transacaoDTOToConta(TransacaoDTO transacaoDTO) {
        if ( transacaoDTO == null ) {
            return null;
        }

        Conta conta = new Conta();

        conta.setId( transacaoDTO.getIdConta() );

        return conta;
    }

    private Integer transacaoContaId(Transacao transacao) {
        if ( transacao == null ) {
            return null;
        }
        Conta conta = transacao.getConta();
        if ( conta == null ) {
            return null;
        }
        Integer id = conta.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
