package com.felzr.cooperativismo.api.associado.service;


import com.felzr.cooperativismo.api.associado.data.AssociadoRepository;
import com.felzr.cooperativismo.api.associado.model.Associado;
import com.felzr.cooperativismo.api.dtos.AssociadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociadoServiceImpl implements AssociadoService {

    @Autowired
    AssociadoRepository associadoRepository;

    @Override
    public void salvarAssociado(AssociadoDto associado) {
        associadoRepository.save(new Associado(associado.getId(), associado.getCpf(), associado.getNome()));
    }

    @Override
    public void editarAssociado(AssociadoDto associado) {
        associadoRepository.save(new Associado(associado.getId(), associado.getCpf(), associado.getNome()));
    }

    @Override
    public void deletarAssociado(String cpf) {
        associadoRepository.deleteByCpf(cpf);
    }

    @Override
    public Associado buscarAsssociadoPorCpf(String cpf) {
        return associadoRepository.findByCpf(cpf);
    }

    @Override
    public List<Associado> buscarTodosOsAssociados() {
        return associadoRepository.findAll();
    }
}
