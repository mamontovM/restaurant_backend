package ru.relex.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import ru.relex.security.model.TokenPair;

public interface ITokenService {
  Jws<Claims> parseJws(String token);

  TokenPair generateTokens(String username);
}
