package com.itb.inf2em.pizzaria.services;

import com.itb.inf2em.pizzaria.model.Categoria;


import java.util.List;

public interface CategoriaService {

    public Categoria salvarCategoria(Categoria categoria);
    public boolean deletarCategoria(Long id);
    public List<Categoria> listarTodasCategorias();
    public Categoria listarCategoriaPorId(Long id);
    public Categoria atualizarCategoria(Categoria categoria, Long id);

    public List<Categoria> listarCategoriasAtivas();
    public Categoria listarCategoriaAtivaPorId(Long id);
    public Categoria deletarCategoriaLogic(Long id);

}
