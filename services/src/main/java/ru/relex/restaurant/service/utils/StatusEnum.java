package ru.relex.restaurant.service.utils;

public enum StatusEnum {
  WaiterTake(1, "Официант принял заказ"),
  CookAssigned (2,"Повар назначен на заказ"),
  CookTake (3, "Повар принял заказ"),
  CookGiven(4,"Повар отдал заказ"),
  WaiterGiven(5,"Официант отдал заказ");

  private int statusId;
  private String name;

  StatusEnum(int statusId, String name) {
    this.statusId = statusId;
    this.name = name;
  }

  public int getStatusId() {
    return statusId;
  }

  public void setStatusId(int statusId) {
    this.statusId = statusId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
