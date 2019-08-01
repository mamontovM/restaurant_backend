package ru.relex.security.mapstruct;


import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.UserDetails;
import ru.relex.restaurant.db.entity.Users;
import ru.relex.security.model.AuthUserDetails;

@Mapper
public interface IUserDetailsMap {

  default UserDetails mapUser(Users user) {
    return new AuthUserDetails(user.getLogin(),
        user.getPassword(),
         user.getRoleId());
  }
}
