package com.unifacisa.sgcb.service;


import com.unifacisa.sgcb.domain.Conta;
import com.unifacisa.sgcb.repository.ContaRepository;
import com.unifacisa.sgcb.repository.PessoaRepository;
import com.unifacisa.sgcb.service.dto.ContaDTO;
import com.unifacisa.sgcb.service.exception.RegraNegocioException;
import com.unifacisa.sgcb.service.mapper.ContaMapper;
import com.unifacisa.sgcb.service.mapper.PessoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class PessoaService {

    private final PessoaRepository repository;

    private final PessoaMapper mapper;

}
