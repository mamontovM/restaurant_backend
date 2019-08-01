package ru.relex.restaurant.service.DTO;

import java.util.List;

public class IngredientsWithTotalCountDto {
  private List<IngredientDto> items;
  private long totalCount;

  public IngredientsWithTotalCountDto() {
  }

  public List<IngredientDto> getItems() {
    return items;
  }

  public void setItems(List<IngredientDto> items) {
    this.items = items;
  }

  public long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(long totalCount) {
    this.totalCount = totalCount;
  }
}
