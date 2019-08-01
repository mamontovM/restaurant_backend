package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.relex.restaurant.db.entity.History;

import java.util.Date;
import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Integer> {

  List<History> findAllByTimeBetweenAndStatusIdIs(Date fromDate, Date toDate, int status);
}
