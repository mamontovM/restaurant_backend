package ru.relex.restaurant.service.DTO;

public class OrderDishIdDto {
  private Integer dishId;

  private Integer orderId;

  public OrderDishIdDto() {
  }

  public Integer getDishId() {
    return dishId;
  }

  public void setDishId(Integer dishId) {
    this.dishId = dishId;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }
}
