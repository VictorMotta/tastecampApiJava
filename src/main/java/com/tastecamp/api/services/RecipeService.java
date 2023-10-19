package com.tastecamp.api.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastecamp.api.dto.RecipesDTO;
import com.tastecamp.api.exceptions.ConflictException;
import com.tastecamp.api.exceptions.ResourceNotFoundException;
import com.tastecamp.api.models.Recipe;
import com.tastecamp.api.repositories.RecipeRepository;


@Service
public class RecipeService {
  
  @Autowired
  private RecipeRepository repository;

  public List<Recipe> findAll() {
    return repository.findAll();
  }

  public Recipe findById(Integer id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found recipe with id: " + id));
  }

  public void create(Recipe data) {
    Recipe recipe = repository.findByName(data.getName());
    if(recipe != null) {
      throw new ConflictException("Recipe already exist!");
    }
    
    repository.save(data);
  }

  public void deleteById(Integer id) {
    repository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));

    repository.deleteById(id);
  }

  public void update(Integer id, RecipesDTO data){
    Recipe recipe = repository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));

    recipe.setName(data.name());
    recipe.setIngredients(data.ingredients());
    recipe.setPreparation(data.preparation());
    recipe.setTime(data.time());
    recipe.setLevel(data.level().getDescription());
    repository.save(recipe);
  }

}
