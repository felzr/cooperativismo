package com.felzr.cooperativismo.api.enums;

public enum VotacaoEnum {
    VOTACAO_FEITA("Voto concluido com sucesso!"),
    ERRO_VOTACAO("Essa votação  já está encerrada!"),
    VOTO_REPETIDO("Associado já votou está pauta!"),
    ASSOCIADO_NAO_VOTANTE("Associado não pode votar está pauta"),
    VOTACAO_FECHADA_OU_ENCERRADA("Está votação está encerrada ou ainda não foi aberta"),
    VOTO_INVALIDO("Voto Invalido!");
    private String votacao;

    VotacaoEnum(String votacao) {
        this.votacao = votacao;
    }

    public String getStatus() {
        return votacao;
    }
}
