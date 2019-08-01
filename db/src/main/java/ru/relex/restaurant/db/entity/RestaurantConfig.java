package ru.relex.restaurant.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_config")
public class RestaurantConfig {
  @Id
  private Integer id;

  @Column(name = "max_storage_volume")
  private Double maxStorageVolume;

  public RestaurantConfig() {
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
