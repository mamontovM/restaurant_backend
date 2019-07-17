package ru.relex.restaurant.db.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "ingredients")
public class Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredients_seq")
  @SequenceGenerator(name = "ingredients_seq", sequenceName = "ingredients_id_seq", allocationSize = 1)
  private Integer id;
  private String name;
  private String measure;

  @OneToMany(mappedBy = "ingredientId", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<IngredientPart> parts;


  public Ingredient() {
  }

  public Ingredient(String name, String measure, List<IngredientPart> parts) {
    this.name = name;
    this.measure = measure;
    this.parts = parts;
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

  public List<IngredientPart> getParts() {
    return parts;
  }

  public void setParts(List<IngredientPart> parts) {
    this.parts = parts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Ingredient that = (Ingredient) o;
    return id.equals(that.id) &&
        name.equals(that.name) &&
        measure.equals(that.measure) &&
        Objects.equals(parts, that.parts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, measure, parts);
  }
}
