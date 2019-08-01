package ru.relex.security.filters;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import ru.relex.security.service.ITokenService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtRefreshFilter extends BasicAuthenticationFilter {

  public static final Logger logger = LoggerFactory.getLogger(JwtRefreshFilter.class);

  private static final String REFRESH_API = "/refresh";
  private static final String AUTH = "Authorization";
  private static final String BEARER = "Bearer ";

  private final ITokenService service;
  private final ObjectMapper objectMapper = new ObjectMapper();

  public JwtRefreshFilter(final AuthenticationManager authenticationManager, final ITokenService service) {
    super(authenticationManager);
    this.service = service;
  }

  @Override
  protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws IOException, ServletException {
    var path = request.getContextPath();
    if ("/".equals(path)) {
      path = "";
    }
    var reqUri = request.getRequestURI();

    if (!(path + REFRESH_API).equalsIgnoreCase(reqUri)) {
      chain.doFilter(request, response);
      return;
    }

    var auth = request.getHeader(AUTH);
    if (auth == null || auth.isBlank()) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      logger.debug("No authentication information provided to access {}", reqUri);
      return;
    }

    if (!auth.startsWith(BEARER)) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      logger.debug("No Bearer token provided to access {}", reqUri);
      return;
    }

    var jwt = auth.substring(BEARER.length());
    Authentication authentication;
    try {
      Jws<Claims> jwtToken = service.parseJws(jwt);

      if (!jwtToken.getBody().containsKey("refresh")) {
        throw new BadCredentialsException("No refresh tokens allowed here!");
      }

      var tokens = service.generateTokens(jwtToken.getBody().getSubject());

      response.setStatus(HttpServletResponse.SC_OK);
      try (var writer = response.getWriter()) {
        objectMapper.writeValue(writer, tokens);
      }

    } catch (Exception e) {
      logger.debug("Failed to parse token", e);
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
  }
}
