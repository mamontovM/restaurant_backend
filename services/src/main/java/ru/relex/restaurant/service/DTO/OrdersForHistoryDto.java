package ru.relex.restaurant.service.DTO;

import java.util.List;

public class OrdersForHistoryDto {
  private int id;
  private String comments;
  private List<OrderDishDto> consist;

  public OrdersForHistoryDto() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public List<OrderDishDto> getConsist() {
    return consist;
  }

  public void setConsist(List<OrderDishDto> consist) {
    this.consist = consist;
  }
}
