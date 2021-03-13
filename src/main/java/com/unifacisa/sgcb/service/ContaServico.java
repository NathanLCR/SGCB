package com.unifacisa.sgcb.service;


import com.unifacisa.sgcb.domain.Conta;
import com.unifacisa.sgcb.repository.ContaRepository;
import com.unifacisa.sgcb.service.dto.ContaDTO;
import com.unifacisa.sgcb.service.exception.RegraNegocioException;
import com.unifacisa.sgcb.service.mapper.ContaMapper;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ContaServico {

    private final ContaRepository repository;

    private final ContaMapper mapper;

    private void salvar (Conta conta){
        conta = repository.save(conta);
    }

    private Conta consultaContaPorId (Integer id){
        if (!repository.existsById(id)){
            throw new RegraNegocioException("Conta inexistente");
        }

        return repository.getOne(id);
    }

    public ContaDTO createConta (ContaDTO contaDTO){
        Conta conta = mapper.toEntity(contaDTO);
        salvar(conta);
        return mapper.toDto(conta);
    }

    public Double consultaSaldo (Integer id){
        Conta conta = consultaContaPorId(id);
        return conta.getSaldo();
    }

    public ContaDTO realizaTransacao (Integer id, Double valorTransacao){
        Conta conta = consultaContaPorId(id);
        Double saldo = conta.getSaldo() + valorTransacao;
        if (saldo < 0){
            throw new RegraNegocioException("Saldo insuficiente!");
        }
        verificaLimiteLimiteSaque(conta, valorTransacao);
        conta.setSaldo(saldo);
        salvar(conta);
        return mapper.toDto(conta);
    }

    private Boolean isSaque (Double valorTransacao){
        return valorTransacao < 0;
    }

    private void verificaLimiteLimiteSaque (Conta conta, Double valorTransacao) {
        if (isSaque(valorTransacao) && valorTransacao * -1 > conta.getLimiteSaqueDiario()){
            throw new RegraNegocioException("Limite de saque excedido!");
        }
    }

    public ContaDTO bloqueioConta (Integer id){
        Conta conta = consultaContaPorId(id);
        conta.setFlagAtivo(false);
        salvar(conta);
        return mapper.toDto(conta);
    }
}
