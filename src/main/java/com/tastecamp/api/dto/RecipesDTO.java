package com.tastecamp.api.dto;

import com.tastecamp.api.models.Level;

public record RecipesDTO(
  String name,
  String ingredients,
  String preparation,
  int time,
  Level level
  ) {
  
}

