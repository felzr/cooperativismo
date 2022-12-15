package com.felzr.cooperativismo.api.enums;

public enum ResponsePautaEnum {
    RESPONSE_SUCESS_SAVE("Pauta salva com sucesso"),
    RESPONSE_SUCESS_DELETE("Pauta deletada com sucesso"),
    RESPONSE_SUCESS_EDIT("Pauta editada com sucesso"),
    RESPONSE_SUCESS_OPEN("Votacao aberta com sucesso");

    private String status;

    ResponsePautaEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
