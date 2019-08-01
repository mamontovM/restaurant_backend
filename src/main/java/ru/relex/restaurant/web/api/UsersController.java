package ru.relex.restaurant.web.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ru.relex.restaurant.service.DTO.UserDto;
import ru.relex.restaurant.service.IUserService;
import ru.relex.restaurant.service.impl.UserService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(value = "/users",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UsersController {
  private final IUserService userService;

  public UsersController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "{id}")
  public UserDto getById(@PathVariable("id") int id) {
    UserDto userDto = userService.getById(id);
    if (userDto == null) {
      return null;
    }
    return userDto;
  }

  @PutMapping
  @RolesAllowed({"ADMIN"})
  public UserDto update(@RequestBody UserDto userDto) {
    UserDto updatedUser = userService.update(userDto);
    if (updatedUser == null) {
      return null;
    }
    return updatedUser;
  }

  @PostMapping
  @RolesAllowed({"ADMIN"})
  public boolean insert(@RequestBody UserDto userDto) {
    return userService.insert(userDto);
  }

  @DeleteMapping("{id}")
  @RolesAllowed({"ADMIN"})
  public boolean deleteById(@PathVariable("id") int id) {
    return userService.deleteById(id);
  }

  @GetMapping("/getAll")
  public List<UserDto> getAll() {
    List<UserDto> userDtosList = userService.getAll();
    if (userDtosList.isEmpty()) {
      return null;
    }
    return userDtosList;
  }

  @GetMapping("/getAllCook")
  public List<UserDto> getAllCook() {
    return userService.getAllCook();
  }


}
