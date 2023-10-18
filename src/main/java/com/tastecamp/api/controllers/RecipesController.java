package com.tastecamp.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dto.RecipesDTO;

@RestController
@RequestMapping("/api/recipes")
public class RecipesController {
  
  @GetMapping
  public String getAll() {
    return "Retornou todas as receitas!";
  };

  @PostMapping
  public void create(@RequestBody RecipesDTO req) {
    System.out.println(req);
  }

}
