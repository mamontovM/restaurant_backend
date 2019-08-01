package ru.relex.security.currentUserUtils;

public enum Role {

  ADMIN(1),
  COOKER(2),
  WAITER(3),
  KEEPER(4)
  ;

  private final int id;

  Role(final int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public static Role of(Integer id) {
    if (id == null) {
      return null;
    }

    for (var value: values()) {
      if (value.id == id) {
        return value;
      }
    }

    return null;
  }
}
