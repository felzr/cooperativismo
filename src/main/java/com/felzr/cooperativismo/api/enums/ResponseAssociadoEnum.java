package com.felzr.cooperativismo.api.enums;

public enum ResponseAssociadoEnum {
    RESPONSE_SUCESS_SAVE("Associado salvo com sucesso"),
    RESPONSE_SUCESS_DELETE("Associado deletado com sucesso"),
    RESPONSE_SUCESS_EDIT("Associado editado com sucesso");

    private String status;

    ResponseAssociadoEnum(String status) { this.status = status; }

    public String getStatus() { return status; }
}
