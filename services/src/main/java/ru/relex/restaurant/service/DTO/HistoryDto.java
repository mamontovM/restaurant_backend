package ru.relex.restaurant.service.DTO;


import java.util.Date;

public class HistoryDto {
  private int id;
  private Date time;
  private OrdersForHistoryDto order;


  private int statusId;
  private int userId;
  private Integer cook_id;

  public HistoryDto() {


  }

  public HistoryDto(int id, Date time, OrdersForHistoryDto order, int statusId, int userId, Integer cook_id) {
    this.id = id;
    this.time = time;
    this.order = order;
    this.statusId = statusId;
    this.userId = userId;
    this.cook_id = cook_id;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }


  public OrdersForHistoryDto getOrder() {
    return order;
  }

  public void setOrder(OrdersForHistoryDto order) {
    this.order = order;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int user_id) {
    this.userId = user_id;
  }

  public Integer getCook_id() {
    return cook_id;
  }

  public void setCook_id(Integer cook_id) {
    this.cook_id = cook_id;
  }

  public int getStatusId() {
    return statusId;
  }

  public void setStatusId(int statusId) {
    this.statusId = statusId;
  }
}

