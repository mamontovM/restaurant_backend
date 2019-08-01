package ru.relex.restaurant.service.DTO;

import java.util.List;

public class DishDto {

  private Integer id;
  private String name;
  private Double cost;
  private String type;
  private Boolean ismenu;
  private Integer maxCount;
  private List<DishIngredientDto> consist;
  private Boolean editable;

  public DishDto() {
  }

  public List<DishIngredientDto> getConsist() {
    return consist;
  }

  public void setConsist(List<DishIngredientDto> consist) {
    this.consist = consist;
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

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getIsmenu() {
    return ismenu;
  }

  public void setIsmenu(Boolean ismenu) {
    this.ismenu = ismenu;
  }

  public Integer getMaxCount() {
    return maxCount;
  }

  public void setMaxCount(Integer maxCount) {
    this.maxCount = maxCount;
  }

  public Boolean getEditable() {
    return editable;
  }

  public void setEditable(Boolean editable) {
    this.editable = editable;
  }
}
