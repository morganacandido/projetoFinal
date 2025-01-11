package br.com.papelaria.projetoFinal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.papelaria.projetoFinal.model.Produto;
import br.com.papelaria.projetoFinal.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findAll() {
        return this.produtoRepository.findAll();
    }
 
    public Produto findById(String id) {
        return this.produtoRepository.findById(id).orElseThrow(()  -> new RuntimeException("Produto não encontrado"));
    }

    public Produto save(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public Produto update(Produto produto){
        var produtoEntity = this.findById(produto.getId());
        BeanUtils.copyProperties(produto, produtoEntity);
        return this.produtoRepository.save(produtoEntity);
    }

    public void delete(String id) {
        this.produtoRepository.deleteById(id);
    }

}
