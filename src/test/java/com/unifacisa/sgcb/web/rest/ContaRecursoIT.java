package com.unifacisa.sgcb.web.rest;

import com.unifacisa.sgcb.builder.ContaBuilder;
import com.unifacisa.sgcb.domain.Conta;
import com.unifacisa.sgcb.repository.ContaRepository;
import com.unifacisa.sgcb.service.mapper.ContaMapper;
import com.unifacisa.sgcb.util.IntTestComum;
import com.unifacisa.sgcb.util.TestUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@RunWith(SpringRunner.class)
@Transactional
public class ContaRecursoIT extends IntTestComum {

    @Autowired
    private ContaBuilder contaBuilder;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ContaMapper contaMapper;

    @BeforeEach
    public void limparBanco() {
        contaRepository.deleteAll();
    }

    @Test
    public void criarConta() throws Exception {
        Conta conta = contaBuilder.construirEntidade();
        getMockMvc().perform(post("/api/conta/")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(contaMapper.toDto(conta)))
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idPessoa").value(conta.getPessoa().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tipoConta").value(conta.getTipoConta()));

    }

    @Test
    public void bloquearConta() throws Exception {
        Conta conta = contaBuilder.construirEntidadeEPersistir();
        getMockMvc().perform(put("/api/conta/bloquear/" + conta.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.flagAtivo").value(false));
    }

    @Test
    public void consultarSaldo() throws Exception {
        Conta conta = contaBuilder.construirEntidadeEPersistir();
        getMockMvc().perform(get("/api/conta/saldo/" + conta.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(0.0));
    }
}

