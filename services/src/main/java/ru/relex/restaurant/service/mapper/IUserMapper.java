package ru.relex.restaurant.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.relex.restaurant.db.entity.Users;
import ru.relex.restaurant.service.DTO.UserDto;

import java.util.List;


@Mapper(componentModel = "spring")
public abstract class IUserMapper {

  private PasswordEncoder passwordEncoder;

  @Autowired
  public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  String mapPassword(UserDto dto) {
    return passwordEncoder.encode(dto.getPassword());
  }

  @Mapping(target = "password", expression = "java(mapPassword(userDto))")
  public abstract Users fromDto(UserDto userDto);

  public abstract UserDto toDto(Users user);

  public abstract List<Users> fromDto(List<UserDto> userDtoList);

  public abstract List<UserDto> toDto(List<Users> usersList);
}
