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
import ru.relex.restaurant.service.DTO.RoleDTO;
import ru.relex.restaurant.service.ITestService;

@RestController
@RequestMapping(value =
    "/hello", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MainController {


  private final ITestService service;

  public MainController(ITestService service) {
    this.service = service;
  }


  @GetMapping
  public RoleDTO getByID(@RequestParam("id") int id) {
    RoleDTO roleDto = null;
    if (roleDto == null) {
      return null;//изменить на ошибку
    }
    return roleDto;
  }

}
