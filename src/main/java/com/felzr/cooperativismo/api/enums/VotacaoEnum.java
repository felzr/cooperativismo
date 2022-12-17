package com.felzr.cooperativismo.api.enums;

public enum VotacaoEnum {
    VOTACAO_FEITA("Voto concluido com sucesso!"),
    ERRO_VOTACAO("Essa votacao já está encerrada!"),
    VOTO_REPETIDO("Associado já votou está pauta!");
    private String votacao;

    VotacaoEnum(String votacao) {
        this.votacao = votacao;
    }

    public String getStatus() {
        return votacao;
    }
}
