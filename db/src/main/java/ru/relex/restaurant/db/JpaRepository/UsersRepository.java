package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.restaurant.db.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
  public List<Users> findByRoleId(int id);

  public Optional<Users> findByLoginIgnoreCase(String login);

  public Integer getRoleIdByLogin(String login);

  public Users findByRoleId(String role);

  public Users findByLogin(String login);
}
