package ru.relex.restaurant.db.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDishId implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "order_id")
  private Integer orderId;

  @Column(name = "dish_id")
  private Integer dishId;

  public OrderDishId() {
  }

  public OrderDishId(Integer orderId, Integer dishId) {
    this.orderId = orderId;
    this.dishId = dishId;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getDishId() {
    return dishId;
  }

  public void setDishId(Integer dishId) {
    this.dishId = dishId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderDishId that = (OrderDishId) o;
    return Objects.equals(orderId, that.orderId) &&
        Objects.equals(dishId, that.dishId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, dishId);
  }

  @Override
  public String toString() {
    return "OrderDishId{" +
        "orderId=" + orderId +
        ", dishId=" + dishId +
        '}';
  }
}
