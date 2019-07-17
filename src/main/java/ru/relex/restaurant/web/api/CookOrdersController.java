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
import ru.relex.restaurant.service.DTO.CookOrdersDto;
import ru.relex.restaurant.service.impl.CookOrdersService;

import java.util.List;

@RestController
@RequestMapping(value =
    "/cookorders")
public class CookOrdersController {
  private final CookOrdersService cookOrdersService;

  public CookOrdersController(CookOrdersService cookOrdersService) {
    this.cookOrdersService = cookOrdersService;
  }

  @GetMapping("{id}")
  public CookOrdersDto getByid(@PathVariable("id") int id) {
    CookOrdersDto ordersDto = cookOrdersService.getById(id);
    if (ordersDto == null) {
      return null;
    }
    return ordersDto;
  }

  @GetMapping("/getAll")
  public List<CookOrdersDto> getAll() {
    return cookOrdersService.getAll();
  }

  @PostMapping
  public boolean insert(@RequestBody CookOrdersDto cookOrdersDto) {
    boolean isDone = cookOrdersService.insert(cookOrdersDto);
    return isDone;

  }

  @PutMapping
  public CookOrdersDto update(@PathVariable CookOrdersDto cookOrdersDto) {
    CookOrdersDto updatedOrders = cookOrdersService.update(cookOrdersDto);
    if (updatedOrders == null) {
      return null;
    }
    return updatedOrders;
  }
}
