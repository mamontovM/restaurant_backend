package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.relex.restaurant.db.entity.Dish;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {

  @Query("select o from Dish o where ismenu = true")
  List<Dish> findAllDishesInMenu();

  Page<Dish> findDishesByNameLikeIgnoreCase(String like, Pageable sort);
}
