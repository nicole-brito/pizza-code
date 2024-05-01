package com.soulcode.pizzacode2.controller;

import com.soulcode.pizzacode2.domain.Pizza;
import com.soulcode.pizzacode2.service.PizzaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
@Slf4j
@RequiredArgsConstructor
public class PizzaController {

    @Autowired
    private final PizzaService pizzaService;

    @GetMapping("/")
    public ResponseEntity<List<Pizza>> findAll() {
        List<Pizza> pizzas = pizzaService.findAll();
        if (pizzas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pizzas, HttpStatus.OK);
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<?> getPizzaById(@PathVariable Long idPizza) {
        try {
            Pizza pizza = pizzaService.findByIdPizza(idPizza);
            return new ResponseEntity<>(pizza, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Erro ao criar a pizza", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addpizza")
    public ResponseEntity<?> createPizza(@RequestBody Pizza pizza) {
        try {
            Pizza createdPizza = pizzaService.createPizza(pizza);
            return new ResponseEntity<>(createdPizza, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            log.error("Erro ao criar nova pizza");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{idPizza}")
    public ResponseEntity<?> upddatePizza(@RequestBody Pizza pizza) {
        try {
            Pizza updatedPizza = pizzaService.updatePizza(pizza);
            return new ResponseEntity<>(updatedPizza, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Erro ao editar a pizza ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<?> deleteById(@PathVariable Long idPizza) {
        try {
            Pizza deletedPizza = pizzaService.deletePizza(idPizza);
            return new ResponseEntity<>(deletedPizza, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Erro ao deletar a pizza");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
