package com.felzr.cooperativismo.api.pauta.controller;

import com.felzr.cooperativismo.api.dtos.VotoDto;
import com.felzr.cooperativismo.api.enums.ResponseAssociadoEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votacao")
public class VotarPautaRestController {

    @PostMapping(value = "/votar-pauta")
    public ResponseEntity<?> votarPauta(@RequestBody VotoDto voto) {
        return new ResponseEntity(ResponseAssociadoEnum.RESPONSE_SUCESS_SAVE.getStatus(), HttpStatus.OK);
    }

}
