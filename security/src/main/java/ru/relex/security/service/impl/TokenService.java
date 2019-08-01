package ru.relex.security.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.UsersRepository;
import ru.relex.restaurant.db.entity.Users;
import ru.relex.security.model.TokenPair;
import ru.relex.security.service.ITokenService;

import java.security.Key;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Service
public class TokenService implements ITokenService {

  private static final Key SIGNING_KEY;
  private final UsersRepository usersRepository;
  private static final int ACCESS_TIME = 30;
  private static final int REFRESH_TIME = 1;

  static {
    final SecureRandom secureRandom = new SecureRandom();

    final byte[] bytes = new byte[512 / 8];
    secureRandom.nextBytes(bytes);

    SIGNING_KEY = Keys.hmacShaKeyFor(bytes);
  }

  public TokenService(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  @Override
  public Jws<Claims> parseJws(String token) {
    return Jwts
        .parser()
        .setSigningKey(SIGNING_KEY)
        .parseClaimsJws(token);
  }

  @Override
  public TokenPair generateTokens(String username) {
    final Instant now = Instant.now();
    var date = Date.from(now);

    Users users = usersRepository.findByLogin(username);
    var userRoles = users.getRoleId();
    var userId = users.getId();
    if (users == null) {// если сущность,то проверить,что пустая || userRoles.isEmpty()
      throw new UsernameNotFoundException("User " + username + " already removed from the system");
    }

    var authToken = Jwts
        .builder()
        .signWith(SIGNING_KEY)
        .setSubject(username)
        .claim("role", userRoles)
        .claim("id", userId)
        .setIssuedAt(date)
        .setExpiration(Date.from(now.plus(Duration.ofMinutes(ACCESS_TIME))))
        .compact();

    var refreshToken = Jwts
        .builder()
        .signWith(SIGNING_KEY)
        .setSubject(username)
        .claim("refresh", true)
        .setIssuedAt(date)
        .setExpiration(Date.from(now.plus(Duration.ofDays(REFRESH_TIME))))
        .compact();

    return new TokenPair(authToken, refreshToken);
  }
}

