package ru.relex.restaurant.db.JpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.restaurant.db.entity.Status;

public interface StatusRepository extends JpaRepository<Status,Integer> {
}
