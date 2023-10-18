package com.tastecamp.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelthController {
  
  @GetMapping("/health")
  public String Health() {
    return "Ok!";
  };

}
