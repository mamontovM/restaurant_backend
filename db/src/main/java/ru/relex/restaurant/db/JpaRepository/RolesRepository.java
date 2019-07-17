package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.restaurant.db.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
