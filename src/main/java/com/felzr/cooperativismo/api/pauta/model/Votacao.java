package com.felzr.cooperativismo.api.pauta.model;

import com.felzr.cooperativismo.api.associado.model.Associado;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "votacao")
public class Votacao {
    @Field("votosSim")
    private Integer votosSim;
    @Field("votosNao")
    private Integer votosNao;
    @Field("associadosQueVotaram")
    private List<Associado> associadosQueVotaram;

    public Votacao(Integer votosSim, Integer votosNao, List<Associado> associadosQueVotaram) {
        this.votosSim = votosSim;
        this.votosNao = votosNao;
        this.associadosQueVotaram = associadosQueVotaram;
    }

    public Integer getVotosSim() {
        return votosSim;
    }

    public void setVotosSim(Integer votosSim) {
        this.votosSim = votosSim;
    }

    public Integer getVotosNao() {
        return votosNao;
    }

    public void setVotosNao(Integer votosNao) {
        this.votosNao = votosNao;
    }

    public List<Associado> getAssociadosQueVotaram() {
        return associadosQueVotaram;
    }

    public void setAssociadosQueVotaram(List<Associado> associadosQueVotaram) {
        this.associadosQueVotaram = associadosQueVotaram;
    }
}
