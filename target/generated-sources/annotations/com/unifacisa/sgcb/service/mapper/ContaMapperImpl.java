package com.unifacisa.sgcb.service.mapper;

import com.unifacisa.sgcb.domain.Conta;
import com.unifacisa.sgcb.domain.Pessoa;
import com.unifacisa.sgcb.service.dto.ContaDTO;
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
public class ContaMapperImpl implements ContaMapper {

    @Override
    public List<Conta> toEntity(List<ContaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Conta> list = new ArrayList<Conta>( dtoList.size() );
        for ( ContaDTO contaDTO : dtoList ) {
            list.add( toEntity( contaDTO ) );
        }

        return list;
    }

    @Override
    public List<ContaDTO> toDto(List<Conta> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ContaDTO> list = new ArrayList<ContaDTO>( entityList.size() );
        for ( Conta conta : entityList ) {
            list.add( toDto( conta ) );
        }

        return list;
    }

    @Override
    public Conta toEntity(ContaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Conta conta = new Conta();

        conta.setPessoa( contaDTOToPessoa( dto ) );
        conta.setId( dto.getId() );
        conta.setSaldo( dto.getSaldo() );
        conta.setLimiteSaqueDiario( dto.getLimiteSaqueDiario() );
        conta.setFlagAtivo( dto.getFlagAtivo() );
        conta.setTipoConta( dto.getTipoConta() );
        conta.setDataCriacao( dto.getDataCriacao() );

        return conta;
    }

    @Override
    public ContaDTO toDto(Conta conta) {
        if ( conta == null ) {
            return null;
        }

        ContaDTO contaDTO = new ContaDTO();

        contaDTO.setIdPessoa( contaPessoaId( conta ) );
        contaDTO.setId( conta.getId() );
        contaDTO.setLimiteSaqueDiario( conta.getLimiteSaqueDiario() );
        contaDTO.setFlagAtivo( conta.getFlagAtivo() );
        contaDTO.setTipoConta( conta.getTipoConta() );
        contaDTO.setDataCriacao( conta.getDataCriacao() );
        contaDTO.setSaldo( conta.getSaldo() );

        return contaDTO;
    }

    protected Pessoa contaDTOToPessoa(ContaDTO contaDTO) {
        if ( contaDTO == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        pessoa.setId( contaDTO.getIdPessoa() );

        return pessoa;
    }

    private Integer contaPessoaId(Conta conta) {
        if ( conta == null ) {
            return null;
        }
        Pessoa pessoa = conta.getPessoa();
        if ( pessoa == null ) {
            return null;
        }
        Integer id = pessoa.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
