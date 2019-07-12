package ru.relex.restaurant.shared.model;

public enum Role {

  ADMIN(1),
  COOK(2),
  WAITER(3),
  PROVISOR(4)
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