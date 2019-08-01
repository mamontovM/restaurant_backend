package ru.relex.restaurant.service.DTO;

public class RestaurantConfigDto {
  private Integer id;
  private Double maxStorageVolume;

  public RestaurantConfigDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getMaxStorageVolume() {
    return maxStorageVolume;
  }

  public void setMaxStorageVolume(Double maxStorageVolume) {
    this.maxStorageVolume = maxStorageVolume;
  }
}
