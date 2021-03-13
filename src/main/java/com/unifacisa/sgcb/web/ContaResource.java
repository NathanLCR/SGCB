package com.unifacisa.sgcb.web;

import com.unifacisa.sgcb.service.ContaServico;
import com.unifacisa.sgcb.service.dto.ContaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/conta")
@RequiredArgsConstructor
public class ContaResource {

    private final ContaServico servico;

    @PostMapping
    public ResponseEntity<ContaDTO> cadastrarConta(@Valid @RequestBody ContaDTO contaDTO) throws URISyntaxException {
        ContaDTO conta = servico.createConta(contaDTO);
        return ResponseEntity.created(new URI("/api/conta/")).body(conta);
    }

    @GetMapping("/saldo/{id}")
    public ResponseEntity<Double> consultaSaldo(@PathVariable Integer id) {
        return ResponseEntity.ok(servico.consultaSaldo(id));
    }

    @PutMapping("/bloquear/{id}")
    public ResponseEntity<ContaDTO> bloquearConta(@PathVariable Integer id) {
        return ResponseEntity.ok(servico.bloqueioConta(id));
    }

}
