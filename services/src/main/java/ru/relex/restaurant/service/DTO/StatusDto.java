package ru.relex.restaurant.service.DTO;

public class StatusDto {
  private int id;
  private String name;
  public StatusDto(){}
  public StatusDto(int id, String name) {
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
