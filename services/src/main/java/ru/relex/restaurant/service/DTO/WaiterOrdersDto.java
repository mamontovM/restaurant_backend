package ru.relex.restaurant.service.DTO;

import ru.relex.restaurant.db.entity.Orders;

import java.util.Date;

public class WaiterOrdersDto {
  private int id;
  private Date timeOfTake;
  private Date timeOfGiven;
  private boolean isReady;

  public WaiterOrdersDto() {
  }

  public WaiterOrdersDto(int id, Date timeOfTake, Date timeOfGiven, boolean isReady) {
    this.id = id;
    this.timeOfTake = timeOfTake;
    this.timeOfGiven = timeOfGiven;
    this.isReady = isReady;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getTimeOfTake() {
    return timeOfTake;
  }

  public void setTimeOfTake(Date timeOfTake) {
    this.timeOfTake = timeOfTake;
  }

  public Date getTimeOfGiven() {
    return timeOfGiven;
  }

  public void setTimeOfGiven(Date timeOfGiven) {
    this.timeOfGiven = timeOfGiven;
  }

  public boolean isReady() {
    return isReady;
  }

  public void setReady(boolean ready) {
    isReady = ready;
  }


}
