package ru.relex.restaurant.db.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_dish")
@Embeddable
public class OrderDish {

  @EmbeddedId
  private OrderDishId id;
  private int count;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dish_id", insertable = false, updatable = false) //
  private Dish dish;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", insertable = false, updatable = false) //
  private Orders order;

  public OrderDish() {
  }

  public OrderDishId getId() {
    return id;
  }

  public void setId(OrderDishId id) {
    this.id = id;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public Dish getDish() {
    return dish;
  }

  public void setDish(Dish dish) {
    this.dish = dish;
  }

  public Orders getOrder() {
    return order;
  }

  public void setOrder(Orders order) {
    this.order = order;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderDish orderDish = (OrderDish) o;
    return count == orderDish.count &&
        Objects.equals(id, orderDish.id) &&
        Objects.equals(dish, orderDish.dish) &&
        Objects.equals(order, orderDish.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, count, dish, order);
  }
}
