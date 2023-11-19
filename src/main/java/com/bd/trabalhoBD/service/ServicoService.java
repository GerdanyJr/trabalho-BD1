package com.bd.trabalhoBD.service;

import java.util.ArrayList;

import com.bd.trabalhoBD.model.Servico;

public interface ServicoService {
    Servico createServico(Servico servico);
    ArrayList<Servico> getAllServicos();
    Servico getServicoById(Integer id);
    Servico updateServico(Integer id, Servico servico);
    void deleteServico(Integer id);
}
