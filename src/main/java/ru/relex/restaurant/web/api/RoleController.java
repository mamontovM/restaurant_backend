package ru.relex.restaurant.web.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.restaurant.service.DTO.RoleDTO;
import ru.relex.restaurant.service.impl.RoleService;

import java.util.List;

@RestController
@RequestMapping(value = "/roles",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleController {
  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @GetMapping("/{id}")
  public RoleDTO getByID(@PathVariable("id") int id) {
    RoleDTO roleDTO = roleService.getById(id);
    if (roleDTO == null) {
      return null;//изменить на ошибку
    }
    return roleDTO;
  }

  @GetMapping("/allUsers")
  public List<RoleDTO> getAll() {
    return roleService.getALL();
  }

}
