package com.felzr.cooperativismo.api.associado.service;


import com.felzr.cooperativismo.api.associado.model.Associado;
import com.felzr.cooperativismo.api.dtos.AssociadoDto;

import java.util.List;

public interface AssociadoService {
    void salvarAssociado(AssociadoDto associado);

    void editarAssociado(AssociadoDto associado);

    void deletarAssociado(String cpf);

    Associado buscarAsssociadoPorCpf(String cpf);

    List<Associado> buscarTodosOsAssociados();
}
