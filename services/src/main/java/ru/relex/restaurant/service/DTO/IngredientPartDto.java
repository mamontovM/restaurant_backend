package ru.relex.restaurant.service.DTO;

import java.sql.Date;

public class IngredientPartDto {
  private Integer id;
  private Double value;
  private Date expirationDate;


  public IngredientPartDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

}
