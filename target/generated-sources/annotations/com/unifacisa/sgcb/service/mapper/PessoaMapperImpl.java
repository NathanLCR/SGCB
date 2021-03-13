package com.unifacisa.sgcb.service.mapper;

import com.unifacisa.sgcb.domain.Pessoa;
import com.unifacisa.sgcb.service.dto.PessoaDTO;
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
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public List<Pessoa> toEntity(List<PessoaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Pessoa> list = new ArrayList<Pessoa>( dtoList.size() );
        for ( PessoaDTO pessoaDTO : dtoList ) {
            list.add( toEntity( pessoaDTO ) );
        }

        return list;
    }

    @Override
    public List<PessoaDTO> toDto(List<Pessoa> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PessoaDTO> list = new ArrayList<PessoaDTO>( entityList.size() );
        for ( Pessoa pessoa : entityList ) {
            list.add( toDto( pessoa ) );
        }

        return list;
    }

    @Override
    public Pessoa toEntity(PessoaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        pessoa.setId( dto.getId() );
        pessoa.setNome( dto.getNome() );
        pessoa.setCpf( dto.getCpf() );
        pessoa.setDataNascimento( dto.getDataNascimento() );

        return pessoa;
    }

    @Override
    public PessoaDTO toDto(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setId( pessoa.getId() );
        pessoaDTO.setNome( pessoa.getNome() );
        pessoaDTO.setCpf( pessoa.getCpf() );
        pessoaDTO.setDataNascimento( pessoa.getDataNascimento() );

        return pessoaDTO;
    }
}
