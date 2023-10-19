package com.tastecamp.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dto.RecipesDTO;
import com.tastecamp.api.models.Recipe;
import com.tastecamp.api.repositories.RecipeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recipes")
public class RecipesController {
  
  @Autowired
  private RecipeRepository repository;

  @GetMapping
  public List<Recipe> getAll() {
    return repository.findAll();
  }

  @PostMapping
  public void create(@RequestBody @Valid RecipesDTO req) {
    repository.save(new Recipe(req));
  }

}
