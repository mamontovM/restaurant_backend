package ru.relex.restaurant.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.UsersRepository;
import ru.relex.restaurant.db.entity.Users;
import ru.relex.restaurant.service.DTO.UserDto;
import ru.relex.restaurant.service.IUserService;
import ru.relex.restaurant.service.mapper.IUserMapper;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
  private final UsersRepository usersRepository;
  private final IUserMapper userMapper;

  public UserService(UsersRepository usersRepository, IUserMapper userMapper) {
    this.usersRepository = usersRepository;
    this.userMapper = userMapper;
  }

  @Override
  public UserDto getById(int id) {
    Optional<Users> usersOptional = usersRepository.findById(id);
    if (!usersOptional.isPresent()) {
      return null;
    }
    Users user = usersOptional.get();
    return userMapper.toDto(user);

  }

  @Override
  public boolean deleteById(int id) {
    Optional<Users> usersOptional = usersRepository.findById(id);
    if (!usersOptional.isPresent()) {
      return false;
    }
    usersRepository.deleteById(id);
    return true;
  }

  @Override
  public boolean insert(UserDto userDto) {
    Users user = userMapper.fromDto(userDto);
    Users newUser = usersRepository.save(user);
    if (newUser == null) {
      return false;
    }
    return true;
  }

  @Override
  public UserDto update(UserDto userDto) {
    Users users = userMapper.fromDto(userDto);
    Users userForUpdate = usersRepository.findById(users.getId()).get();
    if (userForUpdate == null) {
      return null;
    }
    userForUpdate = users;
    Users updatedUser = usersRepository.save(userForUpdate);
    return userMapper.toDto(updatedUser);

  }

  @Override
  public List<UserDto> getAll() {
    List<Users> usersList = usersRepository.findAll();
    return userMapper.toDto(usersList);
  }

  @Override
  public List<UserDto> getAllCook() {
    List<Users> usersList = usersRepository.findByRoleId(2);
    return userMapper.toDto(usersList);
  }
}
