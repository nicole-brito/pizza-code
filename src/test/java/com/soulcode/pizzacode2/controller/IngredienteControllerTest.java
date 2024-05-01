package com.soulcode.pizzacode2.controller;

import com.soulcode.pizzacode2.domain.Ingrediente;
import com.soulcode.pizzacode2.service.IngredienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IngredienteControllerTest {

    @InjectMocks
    IngredienteController ingredienteController;

    @Mock
    IngredienteService ingredienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllReturnsOkWhenIngredientsExist() {
        when(ingredienteService.findAll()).thenReturn(Arrays.asList(new Ingrediente(), new Ingrediente()));
        ResponseEntity<List<Ingrediente>> response = ingredienteController.findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findAllReturnsNoContentWhenNoIngredientsExist() {
        when(ingredienteService.findAll()).thenReturn(Collections.emptyList());
        ResponseEntity<List<Ingrediente>> response = ingredienteController.findAll();
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void getIngredienteByIdReturnsOkWhenIngredientExists() {
        when(ingredienteService.findByIdIngrediente(anyLong())).thenReturn(new Ingrediente());
        ResponseEntity<?> response = ingredienteController.getIngredienteById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getIngredienteByIdReturnsBadRequestWhenExceptionOccurs() {
        when(ingredienteService.findByIdIngrediente(anyLong())).thenThrow(RuntimeException.class);
        ResponseEntity<?> response = ingredienteController.getIngredienteById(1L);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void createBebidaReturnsCreatedWhenSuccessful() {
        when(ingredienteService.createIngrediente(any(Ingrediente.class))).thenReturn(new Ingrediente());
        ResponseEntity<?> response = ingredienteController.createIngrediente(new Ingrediente());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void createBebidaReturnsBadRequestWhenExceptionOccurs() {
        when(ingredienteService.createIngrediente(any(Ingrediente.class))).thenThrow(RuntimeException.class);
        ResponseEntity<?> response = ingredienteController.createIngrediente(new Ingrediente());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void updateIngredienteReturnsOkWhenSuccessful() {
        when(ingredienteService.updateIngrediente(any(Ingrediente.class))).thenReturn(new Ingrediente());
        ResponseEntity<?> response = ingredienteController.upddateIngrediente(new Ingrediente());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void updateIngredienteReturnsBadRequestWhenExceptionOccurs() {
        when(ingredienteService.updateIngrediente(any(Ingrediente.class))).thenThrow(RuntimeException.class);
        ResponseEntity<?> response = ingredienteController.upddateIngrediente(new Ingrediente());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void deleteByIdReturnsOkWhenSuccessful() {
        when(ingredienteService.deleteIngrediente(anyLong())).thenReturn(new Ingrediente());
        ResponseEntity<?> response = ingredienteController.deleteById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteByIdReturnsBadRequestWhenExceptionOccurs() {
        when(ingredienteService.deleteIngrediente(anyLong())).thenThrow(RuntimeException.class);
        ResponseEntity<?> response = ingredienteController.deleteById(1L);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}