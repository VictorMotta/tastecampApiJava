package com.tastecamp.api.dto;

public record RecipesDTO(
  String name,
  String ingredients,
  String preparation,
  int time,
  String level
  ) {
  
}

