package ru.relex.restaurant.db.entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Roles {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
  @SequenceGenerator(name = "roles_seq", sequenceName = "rol_id_seq", allocationSize = 1)
  private int id;
  private String name;
  //@OneToMany(fetch = FetchType.LAZY)
  //private List<Users> usersList;

  public Roles() {
  }

  public Roles(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Roles(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof Roles)) return false;
    Roles roles = (Roles) o;
    return id == roles.id &&
        name.equals(roles.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }


}
