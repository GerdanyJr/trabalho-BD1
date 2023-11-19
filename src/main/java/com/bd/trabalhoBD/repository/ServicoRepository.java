package com.bd.trabalhoBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bd.trabalhoBD.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    boolean existsByNome(String nome);
}
