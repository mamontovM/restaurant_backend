package ru.relex.restaurant.service;

import ru.relex.restaurant.service.DTO.CookOrdersDto;

import java.util.List;

public interface ICookOrdersService {
  public List<CookOrdersDto> getAll();

  public CookOrdersDto getById(int id);

  public CookOrdersDto update(CookOrdersDto cookOrdersDto);

  public boolean insert(CookOrdersDto cookOrdersDto);

}
