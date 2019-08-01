package ru.relex.restaurant.service.DTO;

public class MissingIngredientDto {
  private Integer id;
  private String name;
  private String measure;
  private Double amount;
  private Double needAmount;

  public MissingIngredientDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMeasure() {
    return measure;
  }

  public void setMeasure(String measure) {
    this.measure = measure;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getNeedAmount() {
    return needAmount;
  }

  public void setNeedAmount(Double needAmount) {
    this.needAmount = needAmount;
  }
}
