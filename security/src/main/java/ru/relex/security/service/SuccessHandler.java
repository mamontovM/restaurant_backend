package ru.relex.security.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.security.SecureRandom;

@Service
public class SuccessHandler implements AuthenticationSuccessHandler {

  private static final String BEARER = "Bearer ";
  private static final String AUTHORIZATION = "Authorization";
  private final ITokenService iTokenService;
  private final ObjectMapper objectMapper = new ObjectMapper();

  public SuccessHandler(ITokenService iTokenService) {
    this.iTokenService = iTokenService;
  }

  @Override
  public void onAuthenticationSuccess(final HttpServletRequest request,
                                      final HttpServletResponse response,
                                      final Authentication authentication) throws IOException, ServletException {
    Object principal = authentication.getPrincipal(); // сюда приходят UserDetails после логина
    if (principal instanceof UserDetails) {
      final UserDetails userDetails = (UserDetails) principal;
      var token = iTokenService.generateTokens(userDetails.getUsername());
      try (var writer = response.getWriter()) {
        objectMapper.writeValue(writer, token);
      }
      response.setStatus(HttpServletResponse.SC_OK);
    }
  }


}
