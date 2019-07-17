package ru.relex.restaurant.service.mapper;


import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.Users;
import ru.relex.restaurant.service.DTO.UserDto;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IUserMapper {

  Users fromDto(UserDto userDto);

  UserDto toDto(Users user);

  List<Users> fromDto(List<UserDto> userDtoList);

  List<UserDto> toDto(List<Users> usersList);
}
