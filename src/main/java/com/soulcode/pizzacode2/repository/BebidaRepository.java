package com.soulcode.pizzacode2.repository;

import com.soulcode.pizzacode2.domain.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BebidaRepository extends JpaRepository<Bebida, Long> {

    boolean existsByNome(String nome);

    Optional<Bebida> findByIdBebida(Long idBebida);






}
