package ru.relex.restaurant.service;

import ru.relex.restaurant.service.DTO.RoleDTO;

import java.util.List;

public interface IRoleService {
    public RoleDTO getById(int id);
    public List<RoleDTO> getALL();
}
