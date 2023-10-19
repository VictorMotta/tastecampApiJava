package com.tastecamp.api.dto;

import com.tastecamp.api.models.Level;

import jakarta.validation.constraints.NotNull;



public record RecipesDTO(

  @NotNull 
  String name,
  @NotNull
  String ingredients,
  @NotNull
  String preparation,
  @NotNull
  Integer time,
  @NotNull 
  Level level
  ) {
  
}

