package br.com.papelaria.projetoFinal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.papelaria.projetoFinal.model.Produto;
import br.com.papelaria.projetoFinal.service.ProdutoService;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {
    private final String ProdutoService = null;
            private final ProdutoService produtoService;
        
            public ProdutoController(ProdutoService produtoService){
                this.produtoService = produtoService;
            }
        
            @GetMapping
            public ResponseEntity<List<Produto>> getAllProduto(){
                var produto = this.produtoService.findAll();
                return ResponseEntity.ok(produto);
            }
        
            @GetMapping("/{id}")
            public ResponseEntity<Object> findById(@PathVariable String id) {
                var produto = this.ProdutoService.findById(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        produto = this.produtoService.save(produto);
         return  ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable String id){
        produto = this.produtoService.save(produto);
         return  ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable String id) {
        this.produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
