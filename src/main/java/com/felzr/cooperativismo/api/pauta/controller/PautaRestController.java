package com.felzr.cooperativismo.api.pauta.controller;

import com.felzr.cooperativismo.api.associado.model.Associado;
import com.felzr.cooperativismo.api.dtos.AssociadoDto;
import com.felzr.cooperativismo.api.dtos.PautaDto;
import com.felzr.cooperativismo.api.enums.ResponseAssociadoEnum;
import com.felzr.cooperativismo.api.enums.ResponsePautaEnum;
import com.felzr.cooperativismo.api.pauta.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pauta")
public class PautaRestController {
    @Autowired
    private PautaService pautaService;

    @PostMapping(value = "/salvar-pauta")
    public ResponseEntity<?> salvarPauta(@RequestBody PautaDto pautaDto) {
        pautaService.salvarPauta(pautaDto);
        return new ResponseEntity(ResponsePautaEnum.RESPONSE_SUCESS_SAVE.getStatus(), HttpStatus.OK);
    }

    @PutMapping(value = "/editar-pauta")
    public ResponseEntity<?> editarPauta(@RequestBody PautaDto pautaDto) {
        pautaService.editarPauta(pautaDto);
        return new ResponseEntity(ResponsePautaEnum.RESPONSE_SUCESS_EDIT.getStatus(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletar-pauta/{cpf}")
    public ResponseEntity<?> deletarPautaPorId(String id) {
        pautaService.deletarPauta(id);
        return new ResponseEntity(ResponsePautaEnum.RESPONSE_SUCESS_DELETE.toString(), HttpStatus.OK);
    }

    @GetMapping(value = "/busca-pauta-por-id/{id}")
    PautaDto buscarAsssociadoPorId(String id) {
        return pautaService.buscarPautaPorId(id);
    }

    @GetMapping(value = "/todas")
    List<PautaDto> buscarTodosOsAssociados() {
        return pautaService.buscarTodasAsPautas();
    }

    @PutMapping(value = "/abrir-votacao")
    public ResponseEntity<?> abrirVotacaoPauta(@RequestBody PautaDto pautaDto) {
        pautaService.abrirVotacaoPauta(pautaDto);
        return new ResponseEntity(ResponsePautaEnum.RESPONSE_SUCESS_OPEN.getStatus(), HttpStatus.OK);
    }


}
