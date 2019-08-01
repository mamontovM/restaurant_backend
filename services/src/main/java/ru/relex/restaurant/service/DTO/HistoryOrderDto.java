package ru.relex.restaurant.service.DTO;

import java.util.Date;

public class HistoryOrderDto {

  private int id;
  private Date time;
  private int statusId;
  private int user_id;
  private Integer cook_id;
  public HistoryOrderDto() {
  }

  public HistoryOrderDto(int id, Date time,  int statusId, int user_id, Integer cook_id) {

    this.id = id;
    this.time = time;
    this.statusId = statusId;
    this.user_id = user_id;
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

  public int getStatusId() {
    return statusId;
  }

  public void setStatusId(int statusId) {
    this.statusId = statusId;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public Integer getCook_id() {
    return cook_id;
  }

  public void setCook_id(Integer cook_id) {
    this.cook_id = cook_id;
  }
}
