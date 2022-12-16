package com.felzr.cooperativismo.api.dtos;

public class VotoDto {
    private String voto;
    private String idPauta;
    private String cpfAssociado;

    public VotoDto(String voto, String idPauta, String cpfAssociado) {
        this.voto = voto;
        this.idPauta = idPauta;
        this.cpfAssociado = cpfAssociado;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public String getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(String idPauta) {
        idPauta = idPauta;
    }

    public String getCpfAssociado() {
        return cpfAssociado;
    }

    public void setCpfAssociado(String cpfAssociado) {
        this.cpfAssociado = cpfAssociado;
    }

}
