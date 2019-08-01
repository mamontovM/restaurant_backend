package ru.relex.restaurant.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.relex"})
public class RestaurantApp {
  public static void main(String[] args) {
    SpringApplication.run(RestaurantApp.class, args);
  }
}

