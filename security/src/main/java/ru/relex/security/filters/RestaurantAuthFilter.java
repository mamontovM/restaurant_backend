package ru.relex.security.filters;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.relex.security.model.LoginModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestaurantAuthFilter extends UsernamePasswordAuthenticationFilter {
  private final ObjectMapper mapper = new ObjectMapper();

  public RestaurantAuthFilter(AuthenticationSuccessHandler successHandler,
                              AuthenticationManager authManager) {
    super();
    this.setAllowSessionCreation(false);
    this.setAuthenticationManager(authManager);
    this.setFilterProcessesUrl("/login"); // всё что не логин этим фильтром игнорируется
    this.setAuthenticationSuccessHandler(successHandler);
  }

  @Override
  public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) {

    try {
      var user = mapper.readValue(request.getReader(), LoginModel.class);
      return getAuthenticationManager().authenticate(
          new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
    } catch (IOException e) {
      throw new BadCredentialsException("Failed to parse user login info");
    }
  }
}
