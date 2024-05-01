package com.soulcode.pizzacode2.controller;


import com.soulcode.pizzacode2.domain.Bebida;
import com.soulcode.pizzacode2.model.BebidaDTO;
import com.soulcode.pizzacode2.service.BebidaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bebidas")
@RequiredArgsConstructor
@Slf4j
public class BebidaController {

    @Autowired
    private final BebidaService bebidaService;

    @RequestMapping(value = "/listadebebidas", method = RequestMethod.GET)
    public ResponseEntity<List<Bebida>> findAll() {
        List<Bebida> bebidas = bebidaService.findAll();
        if (bebidas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bebidas, HttpStatus.OK);
    }

    @PostMapping("/addbebida")
    public ResponseEntity<?> createBebida(@RequestBody Bebida bebida) {
        try {
            Bebida createBebida = bebidaService.createBebida(bebida);
            return new ResponseEntity<>(createBebida, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            log.error("Erro ao criar nova bebida", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{idBebida}")
    public ResponseEntity<?> updateBebida(@RequestBody Bebida bebida) {
        try {
            Bebida updateBebida = bebidaService.updateBebida(bebida);
            return new ResponseEntity<>(updateBebida, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Erro ao criar nova bebida", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{idBebida}")
    public ResponseEntity<?> deleteById(@PathVariable Long idBebida) {
        try {
            Bebida deleteById = bebidaService.deleteById(idBebida);
            return new ResponseEntity<>(deleteById, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Erro ao deletar a bebida");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}