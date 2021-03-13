package com.unifacisa.sgcb.web;

import com.unifacisa.sgcb.service.TransacaoService;
import com.unifacisa.sgcb.service.dto.PeriodoDTO;
import com.unifacisa.sgcb.service.dto.TransacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/transacao")
@RequiredArgsConstructor
public class TransacaoResource {

    private final TransacaoService servico;

    @PostMapping("/depositar")
    public ResponseEntity<TransacaoDTO> depositar(@Valid @RequestBody TransacaoDTO transacaoDTO) throws URISyntaxException {
        TransacaoDTO transacao = servico.depositar(transacaoDTO);
        return ResponseEntity.created(new URI("/api/conta/")).body(transacao);
    }

    @PostMapping("/sacar")
    public ResponseEntity<TransacaoDTO> sacar(@Valid @RequestBody TransacaoDTO transacaoDTO) throws URISyntaxException {
        TransacaoDTO transacao = servico.sacar(transacaoDTO);
        return ResponseEntity.created(new URI("/api/conta/")).body(transacao);
    }

    @GetMapping("/extrato/{idConta}")
    public ResponseEntity<List<TransacaoDTO>> extrato(@PathVariable Integer idConta) {
        return ResponseEntity.ok(servico.extrato(idConta));
    }

    @PostMapping("/extrato-periodo/{idConta}")
    public ResponseEntity<List<TransacaoDTO>> extratoPorPeriodo(@PathVariable Integer idConta, @RequestBody PeriodoDTO periodo) {
        return ResponseEntity.ok(servico.extratoPorPeriodo(periodo, idConta));
    }
}
