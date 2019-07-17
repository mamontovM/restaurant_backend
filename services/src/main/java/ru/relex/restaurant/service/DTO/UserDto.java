package ru.relex.restaurant.service.DTO;

import ru.relex.restaurant.db.entity.Roles;

public class UserDto {
  private int id;
  private String login;
  private String password;
  private String name;
  private String surname;
  private Roles roleDto;

  public UserDto() {
  }

  public UserDto(int id, String login, String password, String name, String surname, Roles role, Roles roleDto) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.name = name;
    this.surname = surname;
    this.roleDto = roleDto;
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


  public Roles getRoleDto() {
    return roleDto;
  }

  public void setRoleDto(Roles roleDto) {
    this.roleDto = roleDto;
  }
}
