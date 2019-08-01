package ru.relex.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.relex.security.mapstruct.IUserDetailsMap;
import ru.relex.restaurant.db.JpaRepository.UsersRepository;

@Service
public class RestaurantUserDetailsService implements UserDetailsService {
  private final UsersRepository repository;
  private final IUserDetailsMap mapstruct;

  public RestaurantUserDetailsService(UsersRepository repository, IUserDetailsMap mapstruct) {
    this.repository = repository;
    this.mapstruct = mapstruct;
  }


  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    return repository.findByLoginIgnoreCase(username).map(mapstruct::mapUser).orElseThrow(()-> new UsernameNotFoundException(username + "not found"));

  }
}
