package com.felzr.cooperativismo.api.dtos;


import java.util.List;

public class VotacaoDto {
    private String id;
    private Integer votosSim;
    private Integer votosNao;
    private List<AssociadoDto> associadosQueVotaram;

    public VotacaoDto(String id, Integer votosSim, Integer votosNao, List<AssociadoDto> associadosQueVotaram) {
        this.id = id;
        this.votosSim = votosSim;
        this.votosNao = votosNao;
        this.associadosQueVotaram = associadosQueVotaram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<AssociadoDto> getAssociadosQueVotaram() {
        return associadosQueVotaram;
    }

    public void setAssociadosQueVotaram(List<AssociadoDto> associadosQueVotaram) {
        this.associadosQueVotaram = associadosQueVotaram;
    }
}
