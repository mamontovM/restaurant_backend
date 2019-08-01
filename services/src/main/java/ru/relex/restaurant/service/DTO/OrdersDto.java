package ru.relex.restaurant.service.DTO;


import java.util.List;

public class OrdersDto {
  private int id;
  private String comments;

  private List<HistoryOrderDto> historyList;
  private List<OrderDishDto> consist;

  public OrdersDto() {
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

  public List<HistoryOrderDto> getHistoryList() {
    return historyList;
  }

  public void setHistoryList(List<HistoryOrderDto> historyList) {
    this.historyList = historyList;
  }
}
