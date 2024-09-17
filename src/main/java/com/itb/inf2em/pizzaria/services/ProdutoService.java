package com.itb.inf2em.pizzaria.services;

import com.itb.inf2em.pizzaria.model.Produto;

import java.util.List;

public interface ProdutoService {

    public Produto salvarProduto(Produto produto);
    public boolean deletarProduto(Long id);
    public List<Produto> listarTodosProdutos();
    public Produto listarProdutoPorId(Long id);
    public Produto atualizarProduto(Produto produto, Long id);

}
