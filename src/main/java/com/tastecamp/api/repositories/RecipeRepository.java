package com.tastecamp.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tastecamp.api.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
  
  Recipe findByName(String name);
}
