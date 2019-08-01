package ru.relex.restaurant.web.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.restaurant.service.DTO.OrderDishDto;
import ru.relex.restaurant.service.impl.OrderDishService;

import java.util.List;

@RestController
@RequestMapping(value = "/orderDish",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderDishController {
  private final OrderDishService orderDishService;

  public OrderDishController(OrderDishService orderDishService) {
    this.orderDishService = orderDishService;
  }

  @PostMapping()
  public boolean insertAll(@RequestBody List<OrderDishDto> orderDishDtoList) {
    boolean isDone = orderDishService.insert(orderDishDtoList);
    return isDone;
  }
}
