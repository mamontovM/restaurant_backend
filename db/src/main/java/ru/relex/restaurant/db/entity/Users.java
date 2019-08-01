package ru.relex.restaurant.db.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
  @SequenceGenerator(name = "users_seq", sequenceName = "users_id_seq", allocationSize = 1)
  private int id;
  private String login;
  private String password;
  private String name;
  private String surname;
  private int roleId;

  public Users() {
  }

  public Users(int id, String login, String password, String name, String surname, int roleId) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.name = name;
    this.surname = surname;
    this.roleId = roleId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof Roles)) return false;
    Users users = (Users) o;
    return id == users.id &&
        name.equals(users.name) &&
        login.equals(users.login) &&
        password.equals(users.password) &&
        surname.equals(users.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, password, name, surname, roleId);
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }
}
