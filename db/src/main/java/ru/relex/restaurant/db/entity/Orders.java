package ru.relex.restaurant.db.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
  @SequenceGenerator(name = "orders_seq", sequenceName = "orders_id_seq", allocationSize = 1)
  private int id;
  private String comment;
  @OneToOne(fetch = FetchType.LAZY)
  private WaiterOrders waiterOrders;
  @OneToOne(fetch = FetchType.LAZY)
  private CookOrders cookOrders;

  public Orders() {
  }

  public Orders(int id, String comment) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof Roles)) return false;
    Orders orders = (Orders) o;
    return id == orders.id &&
        comment.equals(orders.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, comment, waiterOrders, cookOrders);
  }
}
