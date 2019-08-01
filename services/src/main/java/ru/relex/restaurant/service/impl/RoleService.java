package ru.relex.restaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.RolesRepository;
import ru.relex.restaurant.db.entity.Roles;
import ru.relex.restaurant.service.DTO.RoleDTO;
import ru.relex.restaurant.service.IRoleService;
import ru.relex.restaurant.service.mapper.IRoleMapper;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
  private final RolesRepository repository;
  private final IRoleMapper roleMapper;

  @Autowired
  public RoleService(RolesRepository repository, IRoleMapper roleMapper) {
    this.repository = repository;
    this.roleMapper = roleMapper;
  }


  @Override
  public RoleDTO getById(int id) {
    Optional<Roles> rolesOptional = repository.findById(id);
    if (!rolesOptional.isPresent()) {
      return null;
    }
    return roleMapper.toDto(rolesOptional.get());
  }

  @Override
  public List<RoleDTO> getALL() {
    List<Roles> roleList = repository.findAll();
    return roleMapper.toDto(roleList);
  }

}
