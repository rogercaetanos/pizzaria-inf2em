package com.itb.inf2em.pizzaria.services;

import com.itb.inf2em.pizzaria.exceptions.BadRequest;
import com.itb.inf2em.pizzaria.exceptions.NotFound;
import com.itb.inf2em.pizzaria.model.Categoria;
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
        return null;
    }

    @Override
    public Categoria listarCategoriaPorId(Long id) {
        return null;
    }

    @Override
    public Categoria atualizarCategoria(Categoria categoria, Long id) {
        return null;
    }
}
