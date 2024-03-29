package com.felzr.cooperativismo.api.pauta.controller;

import com.felzr.cooperativismo.api.dtos.VotoDto;
import com.felzr.cooperativismo.api.enums.VotacaoEnum;
import com.felzr.cooperativismo.api.exception.CooperativismoException;
import com.felzr.cooperativismo.api.pauta.service.VotarPautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votacao")
public class VotarPautaRestController {
    @Autowired
    VotarPautaService votarPautaService;

    @PostMapping(value = "/votar-pauta")
    public ResponseEntity<?> votarPauta(@RequestBody VotoDto voto) throws CooperativismoException {
        votarPautaService.votarPauta(voto);
        return new ResponseEntity<>(VotacaoEnum.VOTACAO_FEITA.getStatus(), HttpStatus.OK);
    }

}
