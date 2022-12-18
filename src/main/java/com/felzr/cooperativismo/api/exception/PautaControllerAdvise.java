package com.felzr.cooperativismo.api.exception;

import com.felzr.cooperativismo.api.enums.VotacaoEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ControllerAdvice(basePackages = "com.felzr.cooperativismo.api.pauta.controller")
public class PautaControllerAdvise {
    @ResponseBody
    @ExceptionHandler
    public ResponseEntity<MessageExceptionHandle> pautaExpection(CooperativismoException cooperativismoException) {
        MessageExceptionHandle message = new MessageExceptionHandle(new Date(), HttpStatus.NOT_FOUND.value(), cooperativismoException.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
