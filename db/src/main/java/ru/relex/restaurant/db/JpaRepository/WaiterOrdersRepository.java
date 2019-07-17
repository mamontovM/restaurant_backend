package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.restaurant.db.entity.WaiterOrders;

public interface WaiterOrdersRepository extends JpaRepository<WaiterOrders, Integer> {
}
