package com.felzr.cooperativismo.api.pauta.service;

import com.felzr.cooperativismo.api.dtos.VotoDto;
import org.springframework.http.ResponseEntity;

public interface VotarPautaService {
    ResponseEntity<String> votarPauta(VotoDto votoDto);
}
