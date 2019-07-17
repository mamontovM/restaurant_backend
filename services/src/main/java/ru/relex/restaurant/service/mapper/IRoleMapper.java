package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.Roles;
import ru.relex.restaurant.service.DTO.RoleDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRoleMapper {
  Roles fromDto(RoleDTO roleDTO);

  RoleDTO toDto(Roles role);

  List<Roles> fromDto(List<RoleDTO> roleDTOList);

  List<RoleDTO> toDto(List<Roles> roleList);

}
