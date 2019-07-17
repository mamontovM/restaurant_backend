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
import ru.relex.restaurant.service.DTO.WaiterOrdersDto;
import ru.relex.restaurant.service.impl.WaiterOrdersService;

import java.util.List;

@RestController
@RequestMapping(value =
    "/waiterorders")
public class WaiterOrdersController {
  private final WaiterOrdersService waiterOrdersService;

  public WaiterOrdersController(WaiterOrdersService waiterOrdersService) {
    this.waiterOrdersService = waiterOrdersService;
  }

  @GetMapping("{id}")
  public WaiterOrdersDto getByid(@PathVariable("id") int id) {
    WaiterOrdersDto ordersDto = waiterOrdersService.getById(id);
    if (ordersDto == null) {
      return null;
    }
    return ordersDto;
  }

  @GetMapping("/getAll")
  public List<WaiterOrdersDto> getAll() {
    return waiterOrdersService.getAll();
  }

  @PostMapping
  public boolean insert(@RequestBody WaiterOrdersDto waiterOrdersDto) {
    boolean isDone = waiterOrdersService.insert(waiterOrdersDto);
    return isDone;

  }

  @PutMapping
  public WaiterOrdersDto update(@PathVariable WaiterOrdersDto waiterOrdersDto) {
    WaiterOrdersDto updatedOrders = waiterOrdersService.update(waiterOrdersDto);
    if (updatedOrders == null) {
      return null;
    }
    return updatedOrders;
  }
}
