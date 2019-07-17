package ru.relex.restaurant.db.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "waiter_orders")
public class WaiterOrders {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "waiter_seq")
  @SequenceGenerator(name = "waiter_seq", sequenceName = "waiter_orders_id_seq", allocationSize = 1)
  private int id;
  private Date timeOfTake;
  private Date timeOfGiven;
  private boolean isReady;
  @OneToOne(fetch = FetchType.LAZY)
  private Orders order;

  public WaiterOrders() {
  }

  public WaiterOrders(int id, Date timeOfTake, Date timeOfGiven, boolean isReady) {
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

  public Orders getOrder() {
    return order;
  }

  public void setOrder(Orders order) {
    this.order = order;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof Roles)) return false;
    WaiterOrders waiter = (WaiterOrders) o;
    return id == waiter.id &&
        timeOfGiven == waiter.timeOfGiven &&
        timeOfTake == waiter.timeOfTake &&
        isReady == waiter.isReady;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, timeOfTake, timeOfGiven, isReady, order);
  }
}
