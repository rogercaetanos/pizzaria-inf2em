package com.itb.inf2em.pizzaria.repository;

import com.itb.inf2em.pizzaria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // é possível criarmos nossas querys personalizadas utilizando a anotação @Query
    // Veja:

    @Query(value = "SELECT * FROM Categoria c WHERE c.cod_status='1'", nativeQuery = true)
    public List<Categoria> listarCategoriasAtivas();

    @Query(value = "SELECT * FROM Categoria c WHERE c.id=?1 AND c.cod_status='1'", nativeQuery = true)
    public Categoria listarCategoriaAtivaPorId(Long id);
}
