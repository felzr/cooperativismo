package com.felzr.cooperativismo.api.pauta.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "pautas")
public class Pauta {
    @Id
    private String id;
    @Field("tema")
    private String tema;
    @Field("descricao")
    private String descricao;
    @Field("dataCriacaoPauta")
    private Date dataCriacaoPauta;
    @Field("dataFimVotacaoPauta")
    private Date dataFimVotacaoPauta;
    @Field("status")
    private String status;
    @Field("votacao")
    private Votacao votacao;

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

    public Date getDataCriacaoPauta() {
        return dataCriacaoPauta;
    }

    public void setDataCriacaoPauta(Date dataCriacaoPauta) {
        this.dataCriacaoPauta = dataCriacaoPauta;
    }

    public Date getDataFimVotacaoPauta() {
        return dataFimVotacaoPauta;
    }

    public void setDataFimVotacaoPauta(Date dataFimVotacaoPauta) {
        this.dataFimVotacaoPauta = dataFimVotacaoPauta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Votacao getVotacao() {
        return votacao;
    }

    public void setVotacao(Votacao votacao) {
        this.votacao = votacao;
    }


}
