package com.tastecamp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dto.RecipesDTO;
import com.tastecamp.api.models.Recipe;
import com.tastecamp.api.repositories.RecipeRepository;

@RestController
@RequestMapping("/api/recipes")
public class RecipesController {
  
  @Autowired
  private RecipeRepository repository;

  @GetMapping
  public String getAll() {
    return "Retornou todas as receitas!";
  }

  @PostMapping
  public void create(@RequestBody RecipesDTO req) {
    repository.save(new Recipe(req));
  }

}
