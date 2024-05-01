package com.soulcode.pizzacode2.controller;

import com.soulcode.pizzacode2.domain.Pizza;
import com.soulcode.pizzacode2.service.PizzaService;
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

class PizzaControllerTest {

    @InjectMocks
    PizzaController pizzaController;

    @Mock
    PizzaService pizzaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllReturnsOkWhenPizzasExist() {
        when(pizzaService.findAll()).thenReturn(Arrays.asList(new Pizza(), new Pizza()));
        ResponseEntity<List<Pizza>> response = pizzaController.findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findAllReturnsNoContentWhenNoPizzasExist() {
        when(pizzaService.findAll()).thenReturn(Collections.emptyList());
        ResponseEntity<List<Pizza>> response = pizzaController.findAll();
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void getPizzaByIdReturnsOkWhenPizzaExists() {
        when(pizzaService.findByIdPizza(anyLong())).thenReturn(new Pizza());
        ResponseEntity<?> response = pizzaController.getPizzaById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getPizzaByIdReturnsBadRequestWhenExceptionOccurs() {
        when(pizzaService.findByIdPizza(anyLong())).thenThrow(RuntimeException.class);
        ResponseEntity<?> response = pizzaController.getPizzaById(1L);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void createPizzaReturnsCreatedWhenSuccessful() {
        when(pizzaService.createPizza(any(Pizza.class))).thenReturn(new Pizza());
        ResponseEntity<?> response = pizzaController.createPizza(new Pizza());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void createPizzaReturnsBadRequestWhenExceptionOccurs() {
        when(pizzaService.createPizza(any(Pizza.class))).thenThrow(RuntimeException.class);
        ResponseEntity<?> response = pizzaController.createPizza(new Pizza());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void updatePizzaReturnsOkWhenSuccessful() {
        when(pizzaService.updatePizza(any(Pizza.class))).thenReturn(new Pizza());
        ResponseEntity<?> response = pizzaController.upddatePizza(new Pizza());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void updatePizzaReturnsBadRequestWhenExceptionOccurs() {
        when(pizzaService.updatePizza(any(Pizza.class))).thenThrow(RuntimeException.class);
        ResponseEntity<?> response = pizzaController.upddatePizza(new Pizza());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void deleteByIdReturnsOkWhenSuccessful() {
        when(pizzaService.deletePizza(anyLong())).thenReturn(new Pizza());
        ResponseEntity<?> response = pizzaController.deleteById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteByIdReturnsBadRequestWhenExceptionOccurs() {
        when(pizzaService.deletePizza(anyLong())).thenThrow(RuntimeException.class);
        ResponseEntity<?> response = pizzaController.deleteById(1L);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}