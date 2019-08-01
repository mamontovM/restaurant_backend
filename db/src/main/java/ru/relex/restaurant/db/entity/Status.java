package ru.relex.restaurant.db.entity;

import javax.persistence.*;

@Entity
@Table
public class Status {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_seq")
  @SequenceGenerator(name = "status_seq", sequenceName = "status_id_seq", allocationSize = 1)
  private int id;
  private String name;
  public Status(){}
  public Status(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
