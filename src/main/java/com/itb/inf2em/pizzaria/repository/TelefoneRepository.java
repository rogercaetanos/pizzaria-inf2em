package com.itb.inf2em.pizzaria.repository;

import com.itb.inf2em.pizzaria.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
