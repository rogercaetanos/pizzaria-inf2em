package com.itb.inf2em.pizzaria.controller;

// @Controller     :  Exclusivo para sistemas WEB
// @RestController :  Exclusivo pra API´S
// @RequestMapping :  Representa a url principal do end-point solicitado  dentro da API
// @GetMapping     :  Representa a complementação da url principal, EXCLUSIVO PARA CONSULTAS (SELECT)
// @PostMapping    :  Representa a complementação da url principal, EXCLUSIVO PARA CADASTROS (INSERT)
// @PutMapping     :  Representa a complementação da url principal, EXCLUSIVO PARA ATUALIZAR (UPDATE)
// @DeleteMapping  :  Representa a complementação da url principal, EXCLUSIVO PARA DELETAR (DELETE)

import com.itb.inf2em.pizzaria.exceptions.BadRequest;
import com.itb.inf2em.pizzaria.model.Categoria;
import com.itb.inf2em.pizzaria.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {

    private final CategoriaService categoriaService;

    public FuncionarioController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> listarTodasCategorias() {
        return ResponseEntity.ok().body(categoriaService.listarTodasCategorias());
    }

    @PostMapping("/categoria")
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/funcionario/categoria").toUriString());
        return ResponseEntity.created(uri).body(categoriaService.salvarCategoria(categoria));
    }

    //@PathVariable :  Representa os parâmetros passados pela url "variáveis"

    @GetMapping("/categoria/{id}")
    public ResponseEntity<Categoria>listarCategoriaPorId(@PathVariable(value = "id") String id) {
        try{
            return ResponseEntity.ok().body(categoriaService.listarCategoriaPorId(Long.parseLong(id)));
        }catch (NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 5. ");
        }
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria categoria, @PathVariable(value = "id") String id) {
        try{
            return ResponseEntity.ok().body(categoriaService.atualizarCategoria(categoria, Long.parseLong(id)));
        }catch (NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 5. ");
        }
    }

    // Object: Representa "QUALQUER TIPO DE (OBJETO): Categoria, Produto, Usuario etc... inclusive uma String"
    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<Object> deletarCategoria(@PathVariable(value = "id") String id) {
        try{
           if(categoriaService.deletarCategoria(Long.parseLong(id))){
               return ResponseEntity.ok().body("Categoria com o id " + id + " excluída com sucesso");
           }
        }catch (NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 5. ");
        }
        return ResponseEntity.ok().body("Não foi possível a exclusão da categoria com o id " + id );
    }
}
