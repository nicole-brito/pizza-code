package com.soulcode.pizzacode2.repository;

import com.soulcode.pizzacode2.domain.Cliente;
import com.soulcode.pizzacode2.domain.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    boolean existsByNome(String nome);

    Optional<Ingrediente> findByIdIngrediente(Long idIngrediente);

}
