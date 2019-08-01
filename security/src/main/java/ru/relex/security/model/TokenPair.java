package ru.relex.security.model;

public class TokenPair {

  private String authToken;
  private String refreshToken;

  public TokenPair(final String authToken, final String refreshToken) {
    this.authToken = authToken;
    this.refreshToken = refreshToken;
  }

  public String getAuthToken() {
    return authToken;
  }

  public void setAuthToken(final String authToken) {
    this.authToken = authToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(final String refreshToken) {
    this.refreshToken = refreshToken;
  }
}
