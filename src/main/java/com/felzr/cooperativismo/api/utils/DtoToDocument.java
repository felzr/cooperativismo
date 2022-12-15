package com.felzr.cooperativismo.api.utils;

import com.felzr.cooperativismo.api.associado.model.Associado;
import com.felzr.cooperativismo.api.dtos.PautaDto;
import com.felzr.cooperativismo.api.dtos.VotacaoDto;
import com.felzr.cooperativismo.api.enums.PautaEnum;
import com.felzr.cooperativismo.api.pauta.model.Pauta;
import com.felzr.cooperativismo.api.pauta.model.Votacao;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DtoToDocument {
    public Pauta converterNovaPautaDtoParaDocumento(PautaDto dto) {
        Pauta pauta = new Pauta();
        pauta.setDataCriacaoPauta(new Date());
        pauta.setDescricao(dto.getDescricao());
        pauta.setStatus(PautaEnum.FECHADA.getStatus());
        pauta.setTema(dto.getTema());
        return pauta;
    }

    public Pauta converterPautaDtoParaDocumento(PautaDto dto) {
        Pauta pauta = new Pauta();
        pauta.setId(dto.getId());
        pauta.setDataCriacaoPauta(DateUtils.convertToDateDefault(dto.getDataCriacaoPauta()));
        pauta.setDescricao(dto.getDescricao());
        pauta.setStatus(PautaEnum.FECHADA.getStatus());
        pauta.setTema(dto.getTema());
        pauta.setVotacao(converterVotacaoDtoParaDocumento(dto.getVotacao()));
        return pauta;
    }

    Votacao converterVotacaoDtoParaDocumento(VotacaoDto votacaoDto) {
        Votacao votacao = new Votacao();
        votacao.setVotosNao(votacaoDto.getVotosNao());
        votacao.setVotosSim(votacaoDto.getVotosSim());
        votacao.setId(votacao.getId());
        List<Associado> associados = votacaoDto.getAssociadosQueVotaram().stream().map(associadoDto -> new Associado(associadoDto.getId(), associadoDto.getCpf(), associadoDto.getNome())).collect(Collectors.toList());
        votacao.setAssociadosQueVotaram(associados);
        return votacao;
    }

    public PautaDto converterPautaParaDto(Pauta pauta) {
        PautaDto dto = new PautaDto();
        dto.setId(pauta.getId());
        dto.setTema(pauta.getTema());
        dto.setDescricao(pauta.getDescricao());
        dto.setDataCriacaoPauta(DateUtils.getLocalDateTime(pauta.getDataCriacaoPauta()));
        if (pauta.getDataFimVotacaoPauta() != null) {
            dto.setDataFimVotacaoPauta(DateUtils.getLocalDateTime(pauta.getDataFimVotacaoPauta()));
        }
        dto.setStatus(pauta.getStatus());
        return dto;
    }
    public Pauta abrirParaVotacao(PautaDto dto) {
        Pauta pauta = new Pauta();
        pauta.setId(dto.getId());
        pauta.setDataCriacaoPauta(DateUtils.convertToDateDefault(dto.getDataCriacaoPauta()));
        pauta.setDescricao(dto.getDescricao());
        pauta.setStatus(PautaEnum.FECHADA.getStatus());
        pauta.setTema(dto.getTema());
        pauta.setVotacao(converterVotacaoDtoParaDocumento(dto.getVotacao()));
        return pauta;
    }


}
