package com.felzr.cooperativismo.api.associado.controller;


import com.felzr.cooperativismo.api.associado.model.Associado;
import com.felzr.cooperativismo.api.associado.service.AssociadoService;
import com.felzr.cooperativismo.api.dtos.AssociadoDto;
import com.felzr.cooperativismo.api.enums.ResponseAssociadoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/associado")
public class AssociadoRestController {

    @Autowired
    AssociadoService associadoService;

    @PostMapping(value = "/salvar-associado")
    public ResponseEntity<?> salvarAssociado(@RequestBody AssociadoDto associado) {
        associadoService.salvarAssociado(associado);
        return new ResponseEntity(ResponseAssociadoEnum.RESPONSE_SUCESS_SAVE.getStatus(), HttpStatus.OK);
    }

    @PutMapping(value = "/editar-associado")
    public ResponseEntity<?> editarAssociado(@RequestBody AssociadoDto associado) {
        associadoService.editarAssociado(associado);
        return new ResponseEntity(ResponseAssociadoEnum.RESPONSE_SUCESS_EDIT.getStatus(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletar-associado/{cpf}")
    public ResponseEntity<?> deletarAssociado(String cpf) {
        associadoService.deletarAssociado(cpf);
        return new ResponseEntity(ResponseAssociadoEnum.RESPONSE_SUCESS_DELETE.toString(), HttpStatus.OK);
    }

    @GetMapping(value = "/busca-associado-por-cpf/{cpf}")
    Associado buscarAsssociadoPorCpf(String cpf) {
        return associadoService.buscarAsssociadoPorCpf(cpf);
    }

    @GetMapping(value = "/todos")
    List<Associado> buscarTodosOsAssociados() {
        return associadoService.buscarTodosOsAssociados();
    }
}
