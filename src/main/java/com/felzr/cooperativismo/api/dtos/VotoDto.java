package com.felzr.cooperativismo.api.dtos;

public class VotoDto {
    private String voto;
    private PautaDto pauta;
    private AssociadoDto associado;

    public VotoDto(String voto, PautaDto pauta, AssociadoDto associado) {
        this.voto = voto;
        this.pauta = pauta;
        this.associado = associado;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public PautaDto getPauta() {
        return pauta;
    }

    public void setPauta(PautaDto pauta) {
        this.pauta = pauta;
    }

    public AssociadoDto getAssociado() {
        return associado;
    }

    public void setAssociado(AssociadoDto associado) {
        this.associado = associado;
    }
}
