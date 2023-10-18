package com.tastecamp.api.models;

public enum Level {
  INICIANTE("iniciante"),
  INTERMEDIARIO("intermediario"),
  AVANCADO("avancado");

  private String description;

  Level(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;  }
}
