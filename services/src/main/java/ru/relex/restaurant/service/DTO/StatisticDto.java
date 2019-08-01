package ru.relex.restaurant.service.DTO;

import java.util.Map;

public class StatisticDto {
  private Map<String, Double> usedIngredients;
  private Map<String, Integer> soldDishes;
  private Double revenue;

  public StatisticDto() {
  }

  public Map<String, Double> getUsedIngredients() {
    return usedIngredients;
  }

  public void setUsedIngredients(Map<String, Double> usedIngredients) {
    this.usedIngredients = usedIngredients;
  }

  public Map<String, Integer> getSoldDishes() {
    return soldDishes;
  }

  public void setSoldDishes(Map<String, Integer> soldDishes) {
    this.soldDishes = soldDishes;
  }

  public Double getRevenue() {
    return revenue;
  }

  public void setRevenue(Double revenue) {
    this.revenue = revenue;
  }
}
