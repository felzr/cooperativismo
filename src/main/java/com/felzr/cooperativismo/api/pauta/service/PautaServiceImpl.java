package com.felzr.cooperativismo.api.pauta.service;

import com.felzr.cooperativismo.api.dtos.PautaDto;
import com.felzr.cooperativismo.api.enums.PautaEnum;
import com.felzr.cooperativismo.api.pauta.data.PautaRepository;
import com.felzr.cooperativismo.api.pauta.model.Pauta;
import com.felzr.cooperativismo.api.pauta.model.Votacao;
import com.felzr.cooperativismo.api.utils.DateUtils;
import com.felzr.cooperativismo.api.utils.DtoToDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PautaServiceImpl implements PautaService {

    @Autowired
    PautaRepository pautaRepository;

    @Autowired
    DtoToDocument dtoToDocument;

    @Override
    public void salvarPauta(PautaDto pautaDto) {
        Pauta pauta = dtoToDocument.converterNovaPautaDtoParaDocumento(pautaDto);
        pautaRepository.save(pauta);
    }

    @Override
    public void editarPauta(PautaDto pautaDto) {
        pautaRepository.save(dtoToDocument.converterPautaDtoParaDocumento(pautaDto));
    }

    @Override
    public void deletarPauta(String id) {
        pautaRepository.deleteById(id);
    }

    @Override
    public PautaDto buscarPautaPorId(String id) {
        return dtoToDocument.converterPautaParaDto(pautaRepository.findAllByIdIs(id));
    }

    @Override
    public List<PautaDto> buscarTodasAsPautas() {
        List<Pauta> pautas = pautaRepository.findAll();
        List<PautaDto> dtos = pautas.stream().map(pauta -> dtoToDocument.converterPautaParaDto(pauta)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public void abrirVotacaoPauta(PautaDto pautaDto) {
        Pauta pauta = new Pauta();
        pauta.setVotacao(new Votacao());
        pauta.setId(pautaDto.getId());
        pauta.setStatus(PautaEnum.ABERTA.getStatus());
        pauta.setDataFimVotacaoPauta(dataVotacao(pautaDto.getDataFimVotacaoPauta()));
        pautaRepository.save(pauta);
    }

    private Date dataVotacao(LocalDateTime dataFimVotacaoPauta) {
        if (dataFimVotacaoPauta == null) {
            return DateUtils.adicionaMinutosData(new Date(), 1);
        }
        return DateUtils.convertToDateDefault(dataFimVotacaoPauta);
    }

}
