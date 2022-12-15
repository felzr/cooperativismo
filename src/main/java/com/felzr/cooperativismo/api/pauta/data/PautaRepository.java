package com.felzr.cooperativismo.api.pauta.data;

import com.felzr.cooperativismo.api.pauta.model.Pauta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PautaRepository extends MongoRepository<Pauta, String> {
    Pauta findAllByIdIs(String id);
}
