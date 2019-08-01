package ru.relex.restaurant.db.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dishes")
public class Dish {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dishes_seq")
  @SequenceGenerator(name = "dishes_seq", sequenceName = "dishes_id_seq", allocationSize = 1)
  private Integer id;

  private String name;

  @Column(updatable = false)
  private Double cost;
  private String type;
  private Boolean ismenu;

  @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<DishIngredient> consist;

  public List<DishIngredient> getConsist() {
    return consist;
  }

  public void setConsist(List<DishIngredient> consist) {
    this.consist = consist;
  }

  public Dish() {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Dish dish = (Dish) o;
    return Objects.equals(id, dish.id) &&
        Objects.equals(name, dish.name) &&
        Objects.equals(cost, dish.cost) &&
        Objects.equals(type, dish.type) &&
        Objects.equals(ismenu, dish.ismenu) &&
        Objects.equals(consist, dish.consist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, cost, type, ismenu, consist);
  }
}
