package ru.relex.restaurant.web.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.restaurant.service.DTO.RestaurantConfigDto;
import ru.relex.restaurant.service.IRestaurantConfigService;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(path = "/config",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ResraurantConfigController {
  private final IRestaurantConfigService configService;

  public ResraurantConfigController(IRestaurantConfigService configService) {
    this.configService = configService;
  }

  @GetMapping
  public RestaurantConfigDto getConfig() {
    return configService.getConfig();
  }

  @PutMapping
  @RolesAllowed({"ADMIN", "KEEPER"})
  public void changeConfig(@RequestBody RestaurantConfigDto configDto) {
    configService.changeConfig(configDto);
  }
}
