package ru.relex.restaurant.web.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.restaurant.service.DTO.OrdersDto;
import ru.relex.restaurant.service.impl.OrdersService;

import java.util.List;

@RestController
@RequestMapping(value = "/orders",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

  @GetMapping("/allOrdersById/{id}")
  public List<OrdersDto> getAllById(@PathVariable("id") int id) {
    return ordersService.getAllById(id);
  }

  @PostMapping
  public OrdersDto insert(@RequestBody OrdersDto ordersDto) {
    OrdersDto createdOrder = ordersService.insert(ordersDto);
    if (createdOrder == null) {
      return null;
    }
    return createdOrder;

  }

  @PutMapping
  public OrdersDto update(@RequestBody OrdersDto ordersDto) {
    OrdersDto updatedOrders = ordersService.update(ordersDto);
    if (updatedOrders == null) {
      return null;
    }
    return updatedOrders;
  }
}
