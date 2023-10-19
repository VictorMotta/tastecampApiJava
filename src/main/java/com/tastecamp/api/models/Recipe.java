package com.tastecamp.api.models;


import com.tastecamp.api.dto.RecipesDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Recipe {

  public Recipe(RecipesDTO req) {
      this.name = req.name();
      this.ingredients = req.ingredients();
      this.preparation = req.preparation();
      this.time = req.time();
      this.level = req.level().getDescription();
    }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(length = 50, nullable = false, unique = true)
  private String name;

  @Column(length = 150, nullable = false)
  private String ingredients;

  @Column(length = 500, nullable = false)
  private String preparation;

  @Column(nullable = false)
  private int time;

  @Column(nullable = false)
  private String level;
}
