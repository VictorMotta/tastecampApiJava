package com.tastecamp.api.dto;

import com.tastecamp.api.models.Level;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;



public record RecipesDTO(

  @NotNull 
  @Size(min = 2, max = 50)
  String name,
  @NotNull
  @Size(min = 20, max = 150)
  String ingredients,
  @NotNull
  @Max(500)
  String preparation,
  @NotNull
  @Positive
  Integer time,
  @NotNull 
  Level level
  ) {
  
}

