package ru.relex.security.currentUserUtils;

import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.UsersRepository;
import ru.relex.restaurant.db.entity.Users;

@Service
public class MapperCurrentUser {
  private final UsersRepository usersRepository;

  public MapperCurrentUser(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  public CurrentUser toUser(String login) {
    Users users = usersRepository.findByLoginIgnoreCase(login).get();
    return new CurrentUser(users.getId(), Role.of(users.getRoleId()));
  }
}
