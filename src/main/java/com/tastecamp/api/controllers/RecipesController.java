package com.tastecamp.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    repository.deleteById(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Integer id, @RequestBody @Valid RecipesDTO req){
    repository.findById(id).map(recipe -> {
      recipe.setName(req.name());
      recipe.setIngredients(req.ingredients());
      recipe.setPreparation(req.preparation());
      recipe.setTime(req.time());
      recipe.setLevel(req.level().getDescription());
      return repository.save(recipe);
    });
  }

}
