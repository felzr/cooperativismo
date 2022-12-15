package com.felzr.cooperativismo.api.pauta.service;

import com.felzr.cooperativismo.api.dtos.PautaDto;

import java.util.List;

public interface PautaService {

    void salvarPauta(PautaDto pautaDto);

    void editarPauta(PautaDto pautaDto);

    void deletarPauta(String id);

    PautaDto buscarPautaPorId(String id);

    List<PautaDto> buscarTodasAsPautas();

    void abrirVotacaoPauta(PautaDto pautaDto);
}
