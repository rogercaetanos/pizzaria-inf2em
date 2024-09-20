package com.itb.inf2em.pizzaria.services;


import com.itb.inf2em.pizzaria.exceptions.BadRequest;
import com.itb.inf2em.pizzaria.exceptions.NotFound;
import com.itb.inf2em.pizzaria.model.Produto;
import com.itb.inf2em.pizzaria.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    // final : Atributo que uma vez atribuído não pode ser modificado
    private final ProdutoRepository produtoRepository;

    // Injeção de dependência utilizando o construtor da classe
    // Método construtor: Quando há a necessidade de criar objetos já passando valores
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    @Override
    public Produto salvarProduto(Produto produto) {
        produto.setCodStatus(true);
        if(!produto.validarProduto()){
          throw new BadRequest(produto.getMensagemErro());
        }
        return produtoRepository.save(produto);
    }

    @Override
    public boolean deletarProduto(Long id) {
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
        } else {
            throw new NotFound("Produto não encontrado com o id " + id);
        }
        return true;
    }

    @Override
    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto listarProdutoPorId(Long id) {
        try{
            return produtoRepository.findById(id).get();
        } catch (Exception ex) {
            throw new NotFound("Produto não encontrado com o id " + id);
        }
    }
    @Override
    public Produto atualizarProduto(Produto produto, Long id) {
        if(!produto.validarProduto()){
            throw new BadRequest(produto.getMensagemErro());
        }
        if(!produtoRepository.existsById(id)){
            throw new NotFound("Produto não encontrado com o id " + id);
        }
        Produto produtoDb = produtoRepository.findById(id).get();
        produtoDb.setNome(produto.getNome());
        produtoDb.setDescricao(produto.getDescricao());
        produtoDb.setTipoProduto(produto.getTipoProduto());
        produtoDb.setPrecoVenda(produto.getPrecoVenda());
        produtoDb.setPrecoCompra(produto.getPrecoCompra());
        produtoDb.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        return produtoRepository.save(produtoDb); // save: Atualiza quando já existe o registro no banco de dados.
    }
}
