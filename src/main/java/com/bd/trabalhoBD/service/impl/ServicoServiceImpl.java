package com.bd.trabalhoBD.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bd.trabalhoBD.handler.exception.ConflictException;
import com.bd.trabalhoBD.handler.exception.NotFoundException;
import com.bd.trabalhoBD.model.Servico;
import com.bd.trabalhoBD.repository.ServicoRepository;
import com.bd.trabalhoBD.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {

    private ServicoRepository servicoRepository;

    public ServicoServiceImpl(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @Override
    public Servico createServico(Servico servico) {
        if (servicoRepository.existsByNome(servico.getNome())) {
            throw new ConflictException("Um serviço com esse nome já foi cadastrado!");
        }
        return servicoRepository.save(servico);
    }

    @Override
    public ArrayList<Servico> getAllServicos() {
        ArrayList<Servico> servicos = (ArrayList<Servico>) servicoRepository.findAll();
        return servicos;
    }

    @Override
    public Servico getServicoById(Integer id) {
        Optional<Servico> foundServicoOptional = servicoRepository.findById(id);
        if (foundServicoOptional.isPresent()) {
            return foundServicoOptional.get();
        } else
            throw new NotFoundException("Serviço não encontrado");
    }

    @Override
    public Servico updateServico(Integer id, Servico servico) {
        Optional<Servico> foundServicoOptional = servicoRepository.findById(id);
        if (foundServicoOptional.isPresent()) {
            Servico foundServico = foundServicoOptional.get();
            foundServico.setNome(servico.getNome());
            foundServico.setDescricao(servico.getDescricao());
            return servicoRepository.save(foundServico);
        } else
            throw new NotFoundException("Serviço não encontrado");
    }

    @Override
    public void deleteServico(Integer id) {
        Optional<Servico> foundServicoOptional = servicoRepository.findById(id);
        if (foundServicoOptional.isPresent()) {
            servicoRepository.delete(foundServicoOptional.get());
        } else
            throw new NotFoundException("Serviço não encontrado");
    }

}
