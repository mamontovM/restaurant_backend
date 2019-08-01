package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.Status;
import ru.relex.restaurant.service.DTO.StatusDto;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IStatusMapper {
  StatusDto toDto(Status status);

  Status fromDto(StatusDto statusDto);

  List<StatusDto> toDto(List<Status> statusList);

  List<Status> fromDto(List<StatusDto> statusDtos);

}
