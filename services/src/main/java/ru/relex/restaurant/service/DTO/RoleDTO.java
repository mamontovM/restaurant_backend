package ru.relex.restaurant.service.DTO;


public class RoleDTO {
  private int id;
  private String name;

  public RoleDTO(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public RoleDTO() {
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
