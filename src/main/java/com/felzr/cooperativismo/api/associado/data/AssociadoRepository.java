package com.felzr.cooperativismo.api.associado.data;


import com.felzr.cooperativismo.api.associado.model.Associado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface AssociadoRepository extends MongoRepository<Associado, String> {

    @Query("{cpf:'?0'}")
    Associado findByCpf(String cpf);

    @Query("{cpf:'?0'}")
    Associado deleteByCpf(String cpf);

    //void deleteById(String id);

}
