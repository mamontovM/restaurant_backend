package ru.relex.restaurant.web.api;


import org.apache.tomcat.jni.User;
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
import ru.relex.restaurant.service.DTO.UserDto;
import ru.relex.restaurant.service.impl.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
  private final UserService userService;

  public UsersController(UserService userService) {
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
  public UserDto update(@RequestBody UserDto userDto) {
    UserDto updatedUser = userService.update(userDto);
    if (updatedUser == null) {
      return null;
    }
    return updatedUser;
  }

  @PostMapping
  public boolean insert(@RequestBody UserDto userDto) {
    return userService.insert(userDto);
  }

  @DeleteMapping("{id}")
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
}
