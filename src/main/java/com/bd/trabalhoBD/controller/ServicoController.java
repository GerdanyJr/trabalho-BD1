package com.bd.trabalhoBD.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bd.trabalhoBD.model.Servico;
import com.bd.trabalhoBD.service.ServicoService;

@RestController
@RequestMapping("/serviço")
public class ServicoController {

    private ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping
    public ResponseEntity<Servico> createServico(@RequestBody Servico servico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoService.createServico(servico));
    }

    @GetMapping
    public ResponseEntity<ArrayList<Servico>> getAllServicos() {
        return ResponseEntity.ok(servicoService.getAllServicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoService.getServicoById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Servico> updateServico(@RequestBody Servico servico, @PathVariable Integer id) {
        return ResponseEntity.ok(servicoService.updateServico(id, servico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Integer id) {
        servicoService.deleteServico(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
