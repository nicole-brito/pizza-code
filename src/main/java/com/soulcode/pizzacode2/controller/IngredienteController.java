package com.soulcode.pizzacode2.controller;

import com.soulcode.pizzacode2.domain.Ingrediente;
import com.soulcode.pizzacode2.service.IngredienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredientes")
@Slf4j
@RequiredArgsConstructor
public class IngredienteController {

    @Autowired
    private final IngredienteService ingredienteService;

    @GetMapping("/")
    public ResponseEntity<List<Ingrediente>> findAll() {
        List<Ingrediente> ingredientes = ingredienteService.findAll();
        if (ingredientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ingredientes, HttpStatus.OK);
    }

    @GetMapping("/{idIngrediente}")
    public ResponseEntity<?> getIngredienteById(@PathVariable Long idIngrediente) {
        try {
            Ingrediente ingrediente = ingredienteService.findByIdIngrediente(idIngrediente);
            return new ResponseEntity<>(ingrediente, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Erro ao criar o ingrediente", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addingrediente")
    public ResponseEntity<?> createIngrediente(@RequestBody Ingrediente ingrediente) {
        try {
            Ingrediente createdIngrediente = ingredienteService.createIngrediente(ingrediente);
            return new ResponseEntity<>(createdIngrediente, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            log.error("Erro ao criar novo ingrediente");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{idIngrediente}")
    public ResponseEntity<?> upddateIngrediente(@RequestBody Ingrediente ingrediente) {
        try {
            Ingrediente updatedIngrediente = ingredienteService.updateIngrediente(ingrediente);
            return new ResponseEntity<>(updatedIngrediente, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Erro ao editar o ingrediente ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/{idIngrediente}")
    public ResponseEntity<?> deleteById(@PathVariable Long idIngrediente) {
        try {
            Ingrediente deletedIngrediente = ingredienteService.deleteIngrediente(idIngrediente);
            return new ResponseEntity<>(deletedIngrediente, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Erro ao deletar o ingrediente");
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
