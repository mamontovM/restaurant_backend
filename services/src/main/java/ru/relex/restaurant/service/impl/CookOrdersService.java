package ru.relex.restaurant.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.CookOrdersRepository;
import ru.relex.restaurant.db.entity.CookOrders;
import ru.relex.restaurant.db.entity.Orders;
import ru.relex.restaurant.service.DTO.CookOrdersDto;
import ru.relex.restaurant.service.DTO.OrdersDto;
import ru.relex.restaurant.service.ICookOrdersService;
import ru.relex.restaurant.service.mapper.ICookOrdersMapper;

import java.util.List;
import java.util.Optional;

@Service
public class CookOrdersService implements ICookOrdersService {
  private final CookOrdersRepository cookOrdersRepository;
  private final ICookOrdersMapper cookOrdersMapper;

  public CookOrdersService(CookOrdersRepository cookOrdersRepository, ICookOrdersMapper cookOrdersMapper) {
    this.cookOrdersRepository = cookOrdersRepository;
    this.cookOrdersMapper = cookOrdersMapper;
  }

  @Override
  public List<CookOrdersDto> getAll() {
    List<CookOrders> cookOrdersList = cookOrdersRepository.findAll();
    return cookOrdersMapper.toDto(cookOrdersList);
  }

  @Override
  public CookOrdersDto getById(int id) {
    Optional<CookOrders> cookOrdersOptional = cookOrdersRepository.findById(id);
    if (cookOrdersOptional.isEmpty()) {
      return null;
    }
    return cookOrdersMapper.toDto(cookOrdersOptional.get());

  }

  @Override
  public CookOrdersDto update(CookOrdersDto cookOrdersDto) {
    CookOrders cookOrders = cookOrdersMapper.fromDto(cookOrdersDto);
    Optional<CookOrders> cookOrdersOptional = cookOrdersRepository.findById(cookOrders.getId());
    if (cookOrdersOptional.isEmpty()) {
      return null;
    }
    CookOrders updatedCookOrders = cookOrdersRepository.save(cookOrdersOptional.get());
    return cookOrdersMapper.toDto(updatedCookOrders);
  }

  @Override
  public boolean insert(CookOrdersDto cookOrdersDto) {
    CookOrders cookOrders = cookOrdersMapper.fromDto(cookOrdersDto);
    if (cookOrders == null) {
      return false;
    }
    cookOrdersRepository.save(cookOrders);
    return true;

  }
}
