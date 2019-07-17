package ru.relex.restaurant.db.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ingredient_parts")
public class IngredientPart {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_parts_seq")
  @SequenceGenerator(name = "ingredient_parts_seq", sequenceName = "ingredient_parts_id_seq", allocationSize = 1)
  private Integer id;
  private Double value;
  private Date expirationDate;
  private Integer ingredientId;


  public IngredientPart() {
  }

  public IngredientPart(Double value, Date expirationDate) {
    this.value = value;
    this.expirationDate = expirationDate;
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

  public Integer getIngredientId() {
    return ingredientId;
  }

  public void setIngredientId(Integer ingredientId) {
    this.ingredientId = ingredientId;
  }

}
