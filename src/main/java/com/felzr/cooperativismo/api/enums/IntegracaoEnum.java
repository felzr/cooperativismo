package com.felzr.cooperativismo.api.enums;

public enum IntegracaoEnum {
    ABLE_TO_VOTE("ABLE_TO_VOTE"),
    UNABLE_TO_VOTE("UNABLE_TO_VOTE");

    private String status;

    IntegracaoEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
