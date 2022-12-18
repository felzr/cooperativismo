package com.felzr.cooperativismo.api.pauta.service;

import com.felzr.cooperativismo.api.associado.data.AssociadoRepository;
import com.felzr.cooperativismo.api.associado.model.Associado;
import com.felzr.cooperativismo.api.dtos.VotoDto;
import com.felzr.cooperativismo.api.enums.IntegracaoEnum;
import com.felzr.cooperativismo.api.enums.PautaEnum;
import com.felzr.cooperativismo.api.enums.VotacaoEnum;
import com.felzr.cooperativismo.api.enums.VotoEnum;
import com.felzr.cooperativismo.api.exception.CooperativismoException;
import com.felzr.cooperativismo.api.integration.ValidarCpfAssociado;
import com.felzr.cooperativismo.api.pauta.data.PautaRepository;
import com.felzr.cooperativismo.api.pauta.model.Pauta;
import com.felzr.cooperativismo.api.pauta.model.Votacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VotarPautaServiceImpl implements VotarPautaService {
    PautaRepository pautaRepository;
    AssociadoRepository associadoRepository;
    ValidarCpfAssociado validarCpfAssociado;

    @Autowired
    VotarPautaServiceImpl(PautaRepository pautaRepository, AssociadoRepository associadoRepository, ValidarCpfAssociado validarCpfAssociado) {
        this.pautaRepository = pautaRepository;
        this.associadoRepository = associadoRepository;
        this.validarCpfAssociado = validarCpfAssociado;
    }

    @Override
    public void votarPauta(VotoDto votoDto) {
        Pauta pauta = pautaRepository.findAllByIdIs(votoDto.getIdPauta());
        validaDataEStatusVotacao(pauta.getDataFimVotacaoPauta(), pauta.getStatus());
        validaVotoRepetido(pauta, votoDto.getCpfAssociado());
        Associado associado = associadoRepository.findByCpf(votoDto.getCpfAssociado());
        Votacao votacaoAssociado = validaVotoValido(votoDto.getVoto(), associado, pauta);
        pauta.setVotacao(votacaoAssociado);
        pautaRepository.save(pauta);
    }

    private void validaVotoRepetido(Pauta pauta, String cpfAssociado) {
        if (pauta.getVotacao().getAssociadosQueVotaram().stream().filter(associado -> associado.getCpf().equals(cpfAssociado)).count() > 0) {
            throw new CooperativismoException(VotacaoEnum.VOTO_REPETIDO.getStatus());
        }
    }

    private void validaDataEStatusVotacao(Date dataFimVotacaoPauta, String status) {
        if (!status.equals(PautaEnum.ABERTA.getStatus())) {
            throw new CooperativismoException(VotacaoEnum.VOTACAO_FECHADA_OU_ENCERRADA.getStatus());
        }
        if (new Date().after(dataFimVotacaoPauta)) {
            throw new CooperativismoException(VotacaoEnum.ERRO_VOTACAO.getStatus());
        }
    }

    private Votacao validaVotoValido(String voto, Associado associado, Pauta pauta) {
        Votacao votacao = pauta.getVotacao();
        if (voto.equals(VotoEnum.SIM.getVoto())) {
            votacao.getAssociadosQueVotaram().add(associado);
            votacao.setVotosSim(votacao.getVotosSim() + 1);
            return votacao;
        }
        if (voto.equals(VotoEnum.NAO.getVoto())) {
            votacao.getAssociadosQueVotaram().add(associado);
            votacao.setVotosNao(votacao.getVotosNao() + 1);
            return votacao;
        }
        throw new CooperativismoException(VotacaoEnum.VOTO_INVALIDO.getStatus());
    }

    private void validaCpf(String cpf) {
        if (validarCpfAssociado.validateCpf(cpf).equals(IntegracaoEnum.UNABLE_TO_VOTE.getStatus())) {
            throw new CooperativismoException(VotacaoEnum.ASSOCIADO_NAO_VOTANTE.getStatus());
        }
    }
}
