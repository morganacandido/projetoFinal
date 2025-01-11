package br.com.papelaria.projetoFinal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.papelaria.projetoFinal.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository <Produto, String> {

}
