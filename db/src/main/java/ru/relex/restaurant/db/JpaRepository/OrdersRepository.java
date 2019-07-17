package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.restaurant.db.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
