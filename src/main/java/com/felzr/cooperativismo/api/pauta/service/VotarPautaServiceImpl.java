package com.felzr.cooperativismo.api.pauta.service;

import com.felzr.cooperativismo.api.associado.data.AssociadoRepository;
import com.felzr.cooperativismo.api.associado.model.Associado;
import com.felzr.cooperativismo.api.dtos.VotoDto;
import com.felzr.cooperativismo.api.enums.VotoEnum;
import com.felzr.cooperativismo.api.pauta.data.PautaRepository;
import com.felzr.cooperativismo.api.pauta.model.Pauta;
import com.felzr.cooperativismo.api.pauta.model.Votacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotarPautaServiceImpl implements VotarPautaService {
    @Autowired
    PautaRepository pautaRepository;
    @Autowired
    AssociadoRepository associadoRepository;

    @Override
    public void votarPauta(VotoDto votoDto) {
        Pauta pauta = pautaRepository.findAllByIdIs(votoDto.getIdPauta());
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
