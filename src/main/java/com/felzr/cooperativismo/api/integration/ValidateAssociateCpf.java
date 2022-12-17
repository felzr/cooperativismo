package com.felzr.cooperativismo.api.integration;

import org.springframework.web.client.RestTemplate;

public class ValidateAssociateCpf {
    private String url = "https://user-info.herokuapp.com/users/";

    String validateCpf(String cpf) {
        RestTemplate restTemplate = new RestTemplate();
        return new String(restTemplate.getForObject(url.concat(cpf), String.class));
    }
}
