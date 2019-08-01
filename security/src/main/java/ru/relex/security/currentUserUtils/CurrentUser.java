package ru.relex.security.currentUserUtils;

public class CurrentUser {

  private final int id;
  private final Role role;

  public CurrentUser(final int id, final Role role) {
    this.id = id;
    this.role = role;
  }

  @Override
  public String toString() {
    return "CurrentUser{" +
        "id=" + id +
        ", role=" + role +
        '}';
  }
}
