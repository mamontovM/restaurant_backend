package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.restaurant.db.entity.CookOrders;

public interface CookOrdersRepository extends JpaRepository<CookOrders, Integer> {
}
