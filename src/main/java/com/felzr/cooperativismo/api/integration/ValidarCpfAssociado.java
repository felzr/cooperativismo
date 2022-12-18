package com.felzr.cooperativismo.api.integration;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ValidarCpfAssociado {
    private String url = "https://user-info.herokuapp.com/users/";

    public String validateCpf(String cpf) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url.concat(cpf), String.class);
    }
}
