package ru.relex.restaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.WaiterOrdersRepository;
import ru.relex.restaurant.db.entity.WaiterOrders;
import ru.relex.restaurant.service.DTO.WaiterOrdersDto;
import ru.relex.restaurant.service.IWaiterOrdersService;
import ru.relex.restaurant.service.mapper.IWaiterOrdersMapper;

import java.util.List;
import java.util.Optional;

@Service
public class WaiterOrdersService implements IWaiterOrdersService {
  private final WaiterOrdersRepository waiterOrdersRepository;
  private final IWaiterOrdersMapper waiterOrdersMapper;

  public WaiterOrdersService(WaiterOrdersRepository waiterOrdersRepository, IWaiterOrdersMapper waiterOrdersMapper) {
    this.waiterOrdersRepository = waiterOrdersRepository;
    this.waiterOrdersMapper = waiterOrdersMapper;
  }

  @Override
  public List<WaiterOrdersDto> getAll() {
    List<WaiterOrders> waiterOrdersList = waiterOrdersRepository.findAll();
    return waiterOrdersMapper.toDto(waiterOrdersList);
  }

  @Override
  public WaiterOrdersDto getById(int id) {
    Optional<WaiterOrders> waiterOrdersOptional = waiterOrdersRepository.findById(id);
    if (waiterOrdersOptional.isEmpty()) {
      return null;
    }
    return waiterOrdersMapper.toDto(waiterOrdersOptional.get());
  }

  @Override
  public boolean insert(WaiterOrdersDto waiterOrders) {
    WaiterOrders newWaiterOrders = waiterOrdersMapper.fromDto(waiterOrders);
    WaiterOrders createdWaiterOrders = waiterOrdersRepository.save(newWaiterOrders);
    if (createdWaiterOrders == null) {
      return false;
    }
    return true;
  }

  @Override
  public WaiterOrdersDto update(WaiterOrdersDto waiterOrders) {
    WaiterOrders newWaiterOrders = waiterOrdersMapper.fromDto(waiterOrders);
    Optional<WaiterOrders> updatedWaiterOrders = waiterOrdersRepository.findById(newWaiterOrders.getId());
    if (updatedWaiterOrders.isEmpty()) {
      return null;
    }
    return waiterOrdersMapper.toDto(updatedWaiterOrders.get());
  }
}
