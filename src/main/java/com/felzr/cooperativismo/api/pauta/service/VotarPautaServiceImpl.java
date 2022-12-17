package com.felzr.cooperativismo.api.pauta.service;

import com.felzr.cooperativismo.api.associado.data.AssociadoRepository;
import com.felzr.cooperativismo.api.associado.model.Associado;
import com.felzr.cooperativismo.api.dtos.VotoDto;
import com.felzr.cooperativismo.api.enums.VotacaoEnum;
import com.felzr.cooperativismo.api.enums.VotoEnum;
import com.felzr.cooperativismo.api.exception.CooperativismoException;
import com.felzr.cooperativismo.api.pauta.data.PautaRepository;
import com.felzr.cooperativismo.api.pauta.model.Pauta;
import com.felzr.cooperativismo.api.pauta.model.Votacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class VotarPautaServiceImpl implements VotarPautaService {
    PautaRepository pautaRepository;
    AssociadoRepository associadoRepository;

    @Autowired
    VotarPautaServiceImpl(PautaRepository pautaRepository, AssociadoRepository associadoRepository) {
        this.pautaRepository = pautaRepository;
        this.associadoRepository = associadoRepository;
    }

    @Override
    public void votarPauta(VotoDto votoDto) {
        Pauta pauta = pautaRepository.findAllByIdIs(votoDto.getIdPauta());
        if (new Date().after(pauta.getDataFimVotacaoPauta())) {
            throw new CooperativismoException(VotacaoEnum.ERRO_VOTACAO.getStatus(), new Throwable());
        }
        if (pauta.getVotacao().getAssociadosQueVotaram().stream().filter(associado -> associado.getCpf().equals(votoDto.getCpfAssociado())).collect(Collectors.toList()).size() > 0) {
            throw new CooperativismoException(VotacaoEnum.VOTO_REPETIDO.getStatus(), new Throwable());
        }
        Associado associado = associadoRepository.findByCpf(votoDto.getCpfAssociado());
        Votacao votacaoAssociado = validaVoto(votoDto.getVoto(), associado, pauta);
        pauta.setVotacao(votacaoAssociado);
        pautaRepository.save(pauta);
    }

    private Votacao validaVoto(String voto, Associado associado, Pauta pauta) {
        Votacao votacao = pauta.getVotacao();
        if (voto.equals(VotoEnum.SIM.getVoto())) {
            votacao.getAssociadosQueVotaram().add(associado);
            votacao.setVotosSim(votacao.getVotosSim() + 1);
            return votacao;
        }
        votacao.getAssociadosQueVotaram().add(associado);
        votacao.setVotosNao(votacao.getVotosNao() + 1);
        return votacao;
    }
}
