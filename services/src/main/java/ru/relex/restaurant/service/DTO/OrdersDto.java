package ru.relex.restaurant.service.DTO;


public class OrdersDto {
  private int id;
  private String comment;

  public OrdersDto() {
  }

  public OrdersDto(int id, String comment) {
    this.id = id;
    this.comment = comment;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
