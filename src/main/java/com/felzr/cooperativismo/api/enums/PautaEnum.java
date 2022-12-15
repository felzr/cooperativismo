package com.felzr.cooperativismo.api.enums;

public enum PautaEnum {
    ABERTA("Aberta"),
    ENCERRADA("Encerrada"),
    FECHADA("Fechada");

    private String status;

    PautaEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
