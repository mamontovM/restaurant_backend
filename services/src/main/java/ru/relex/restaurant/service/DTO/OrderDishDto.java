package ru.relex.restaurant.service.DTO;


public class OrderDishDto {
  private OrderDishIdDto id;
    private int count;
    private DishDto dish;
    public OrderDishDto(){}

  public OrderDishIdDto getId() {
    return id;
  }

  public void setId(OrderDishIdDto id) {
    this.id = id;
  }

  public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DishDto getDish() {
        return dish;
    }

    public void setDish(DishDto dish) {
        this.dish = dish;
    }
}
