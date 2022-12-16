package com.felzr.cooperativismo.api.dtos;

import java.time.LocalDateTime;

public class PautaDto {
    private String id;
    private String tema;
    private String descricao;
    private LocalDateTime dataFimVotacaoPauta;
    private String status;
    private VotacaoDto votacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataFimVotacaoPauta() {
        return dataFimVotacaoPauta;
    }

    public void setDataFimVotacaoPauta(LocalDateTime dataFimVotacaoPauta) {
        this.dataFimVotacaoPauta = dataFimVotacaoPauta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public VotacaoDto getVotacao() {
        return votacao;
    }

    public void setVotacao(VotacaoDto votacao) {
        this.votacao = votacao;
    }
}
