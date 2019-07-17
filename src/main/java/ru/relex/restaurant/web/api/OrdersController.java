package ru.relex.restaurant.web.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.relex.restaurant.service.DTO.OrdersDto;
import ru.relex.restaurant.service.impl.OrdersService;

import java.util.List;

@RestController
@RequestMapping(value =
    "/orders")
public class OrdersController {
  private final OrdersService ordersService;

  public OrdersController(OrdersService ordersService) {
    this.ordersService = ordersService;
  }

  @GetMapping("{id}")
  public OrdersDto getByid(@PathVariable("id") int id) {
    OrdersDto ordersDto = ordersService.getById(id);
    if (ordersDto == null) {
      return null;
    }
    return ordersDto;
  }

  @GetMapping("/getAll")
  public List<OrdersDto> getAll() {
    return ordersService.getAll();
  }

  @PostMapping
  public boolean insert(@RequestBody OrdersDto ordersDto) {
    boolean isDone = ordersService.insert(ordersDto);
    return isDone;

  }

  @PutMapping
  public OrdersDto update(@PathVariable OrdersDto ordersDto) {
    OrdersDto updatedOrders = ordersService.update(ordersDto);
    if (updatedOrders == null) {
      return null;
    }
    return updatedOrders;
  }
}
