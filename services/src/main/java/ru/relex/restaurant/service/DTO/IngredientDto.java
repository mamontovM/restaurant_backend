package ru.relex.restaurant.service.DTO;


import java.util.List;


public class IngredientDto {
  private Integer id;
  private String name;
  private String measure;
  private Double volumePerUnit;
  private List<IngredientPartDto> parts;

  public IngredientDto() {
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

  public Double getVolumePerUnit() {
    return volumePerUnit;
  }

  public void setVolumePerUnit(Double volumePerUnit) {
    this.volumePerUnit = volumePerUnit;
  }

  public List<IngredientPartDto> getParts() {
    return parts;
  }

  public void setParts(List<IngredientPartDto> parts) {
    this.parts = parts;
  }
}
