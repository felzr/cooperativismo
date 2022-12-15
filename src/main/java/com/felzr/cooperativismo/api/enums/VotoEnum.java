package com.felzr.cooperativismo.api.enums;

public enum VotoEnum {
    SIM("Sim"),
    NAO("Nao");
    private String voto;

    VotoEnum(String voto) {
        this.voto = voto;
    }

    public String getVoto() {
        return voto;
    }
}
