package com.tastecamp.api.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dto.RecipesDTO;
import com.tastecamp.api.models.Recipe;
import com.tastecamp.api.services.RecipeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recipes")
public class RecipesController {
  
  @Autowired
  private RecipeService service;

  @GetMapping
  public List<Recipe> getAll() {
    return service.findAll();
  }
  
  @GetMapping("/{id}")
  public Recipe getById(@PathVariable Integer id){
    return service.findById(id);
  }

  @PostMapping
  @ResponseStatus(value = HttpStatus.CREATED)
  public void create(@RequestBody @Valid RecipesDTO req) {
    service.create(new Recipe(req));
  }

  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    service.deleteById(id);
  }


  @ResponseStatus(value = HttpStatus.OK)
  @PutMapping("/{id}")
  public void update(@PathVariable Integer id, @RequestBody @Valid RecipesDTO req){
    service.update(id, req);
  }

}
