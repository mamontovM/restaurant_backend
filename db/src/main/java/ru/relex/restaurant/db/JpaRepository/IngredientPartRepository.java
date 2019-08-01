package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.relex.restaurant.db.entity.IngredientPart;

import java.util.List;

public interface IngredientPartRepository extends JpaRepository<IngredientPart, Integer> {

  @Query(value = "select * from ingredient_parts where ingredient_id=:id",
      nativeQuery = true)
  List<IngredientPart> findAllByIngredientId(@Param("id") Integer ingrId);
}
