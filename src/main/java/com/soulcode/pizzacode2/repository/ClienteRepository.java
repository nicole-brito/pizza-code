package com.soulcode.pizzacode2.repository;

import com.soulcode.pizzacode2.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByLogin(String login);

    Optional<Cliente> findByIdCliente(Long idCliente);
}
