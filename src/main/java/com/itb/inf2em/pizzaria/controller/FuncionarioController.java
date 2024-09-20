package com.itb.inf2em.pizzaria.controller;

// @Controller     :  Exclusivo para sistemas WEB
// @RestController :  Exclusivo pra API´S
// @RequestMapping :  Representa a url principal do end-point solicitado  dentro da API
// @GetMapping     :  Representa a complementação da url principal, EXCLUSIVO PARA CONSULTAS (SELECT)
// @PostMapping    :  Representa a complementação da url principal, EXCLUSIVO PARA CADASTROS (INSERT)
// @PutMapping     :  Representa a complementação da url principal, EXCLUSIVO PARA ATUALIZAR (UPDATE)
// @DeleteMapping  :  Representa a complementação da url principal, EXCLUSIVO PARA DELETAR (DELETE)

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

}
