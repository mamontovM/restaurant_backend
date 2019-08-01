package ru.relex.restaurant.db.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_seq")
  @SequenceGenerator(name = "history_seq", sequenceName = "history_id_seq", allocationSize = 1)
  private int id;
  private Date time;
  private int statusId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Orders order;

  private int userId;

  public History(){

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

  public Orders getOrder() {
    return order;
  }

  public void setOrder(Orders order) {
    this.order = order;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
