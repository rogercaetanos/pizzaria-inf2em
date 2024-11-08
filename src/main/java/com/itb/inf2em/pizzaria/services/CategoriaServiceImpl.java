package com.itb.inf2em.pizzaria.services;

import com.itb.inf2em.pizzaria.exceptions.BadRequest;
import com.itb.inf2em.pizzaria.exceptions.NotFound;
import com.itb.inf2em.pizzaria.model.Categoria;
import com.itb.inf2em.pizzaria.model.Produto;
import com.itb.inf2em.pizzaria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        categoria.setCodStatus(true);
        if(!categoria.validarCategoria()){
            throw new BadRequest(categoria.getMensagemErro());
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public boolean deletarCategoria(Long id) {
        if(categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
        } else {
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
        return true;
    }

    @Override
    public List<Categoria> listarTodasCategorias() {

        return categoriaRepository.findAll();
    }

    @Override
    public Categoria listarCategoriaPorId(Long id) {
        try{
            return categoriaRepository.findById(id).get();
        } catch (Exception ex) {
            throw new NotFound("Categoria não encontrada com o id " + id);
        }

    }
    @Override
    public Categoria atualizarCategoria(Categoria categoria, Long id) {
        if(!categoria.validarCategoria()){
            throw new BadRequest(categoria.getMensagemErro());
        }
        if(!categoriaRepository.existsById(id)){
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
        Categoria categoriaDb = categoriaRepository.findById(id).get();
        categoriaDb.setNome(categoria.getNome());
        categoriaDb.setDescricao(categoria.getDescricao());

        return categoriaRepository.save(categoriaDb); // save: Atualiza quando já existe o registro no banco de dados.
     }

    @Override
    public List<Categoria> listarCategoriasAtivas() {
        return categoriaRepository.listarCategoriasAtivas();
    }

    @Override
    public Categoria listarCategoriaAtivaPorId(Long id) {
        Categoria categoria = categoriaRepository.listarCategoriaAtivaPorId(id);
        if (categoria == null) {
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
        return categoria;
    }

    @Override
    public Categoria deletarCategoriaLogic(Long id) {
        if(categoriaRepository.existsById(id)) {
            Categoria categoria = categoriaRepository.findById(id).get();
            categoria.setCodStatus(false);
            return categoria;
        }else {
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
    }
}



