package ru.relex.security.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import ru.relex.security.model.Role;
import ru.relex.security.service.ITokenService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class  JwtAccessFilter extends BasicAuthenticationFilter {
  public static final Logger logger = LoggerFactory.getLogger(JwtAccessFilter.class);

  private static final String LOGIN_API = "/login";
  private static final String REFRESH_API = "/refresh";
  private static final String AUTH = "Authorization";
  private static final String BEARER = "Bearer ";

  private final ITokenService service;

  public JwtAccessFilter(final AuthenticationManager authenticationManager, final ITokenService service) {
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

    if ((path + LOGIN_API).equalsIgnoreCase(reqUri)
        || (path + REFRESH_API).equalsIgnoreCase(reqUri)) {
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

      if (jwtToken.getBody().containsKey("refresh")) {
        throw new BadCredentialsException("No refresh tokens allowed here!");
      }
      Integer roles = jwtToken.getBody().get("role", Integer.class);


      Set<? extends GrantedAuthority> authorites = Set.of(new SimpleGrantedAuthority("ROLE_"+ Role.of(roles)));
      authentication
          = new UsernamePasswordAuthenticationToken(jwtToken
          .getBody()
          .getSubject(),
          null,
          authorites);
    } catch (Exception e) {
      logger.debug("Failed to parse token", e);
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    SecurityContextHolder
        .getContext()
        .setAuthentication(authentication);

    chain.doFilter(request, response);
  }
}
