package com.felzr.cooperativismo.api.exception;

public class CooperativismoException extends RuntimeException {
    public CooperativismoException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
