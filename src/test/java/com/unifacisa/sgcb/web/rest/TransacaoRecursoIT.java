package com.unifacisa.sgcb.web.rest;

import com.unifacisa.sgcb.builder.ContaBuilder;
import com.unifacisa.sgcb.builder.TransacaoBuilder;
import com.unifacisa.sgcb.domain.Conta;
import com.unifacisa.sgcb.domain.Transacao;
import com.unifacisa.sgcb.repository.ContaRepository;
import com.unifacisa.sgcb.service.mapper.ContaMapper;
import com.unifacisa.sgcb.service.mapper.TransacaoMapper;
import com.unifacisa.sgcb.util.IntTestComum;
import com.unifacisa.sgcb.util.TestUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@RunWith(SpringRunner.class)
@Transactional
public class TransacaoRecursoIT extends IntTestComum {

    @Autowired
    private TransacaoBuilder transacaoBuilder;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransacaoMapper transacaoMapper;

    @BeforeEach
    public void limparBanco() {
        contaRepository.deleteAll();
    }

    @Test
    public void depositar() throws Exception {
        Transacao transacao = transacaoBuilder.construirEntidade();
        transacao.setValor(10.00);
        getMockMvc().perform(post("/api/transacao/depositar")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(transacaoMapper.toDto(transacao)))
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idConta").value(transacao.getConta().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valor").value(transacao.getValor()));

        getMockMvc().perform(get("/api/conta/saldo/" + transacao.getConta().getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(10.0));

    }

    @Test
    public void sacar() throws Exception {
        Transacao transacao = transacaoBuilder.construirEntidade();
        transacao.setValor(10.00);
        getMockMvc().perform(post("/api/transacao/depositar")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(transacaoMapper.toDto(transacao))));

        transacao.setValor(5.00);
        getMockMvc().perform(post("/api/transacao/sacar")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(transacaoMapper.toDto(transacao)))
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idConta").value(transacao.getConta().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valor").value(transacao.getValor()));

        getMockMvc().perform(get("/api/conta/saldo/" + transacao.getConta().getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(5.0));

    }

    @Test
    public void extrato() throws Exception {
        Transacao transacao = transacaoBuilder.construirEntidade();
        transacao.setValor(10.00);
        getMockMvc().perform(post("/api/transacao/depositar")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(transacaoMapper.toDto(transacao))));


        transacao.setValor(5.00);
        getMockMvc().perform(post("/api/transacao/sacar")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(transacaoMapper.toDto(transacao))));

        getMockMvc().perform(get("/api/transacao/extrato/" + transacao.getConta().getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id", Matchers.hasSize(2)));

    }


}

