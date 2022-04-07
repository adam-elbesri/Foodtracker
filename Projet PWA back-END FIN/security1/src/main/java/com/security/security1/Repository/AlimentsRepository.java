package com.security.security1.Repository;

import com.security.security1.Model.Aliments;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AlimentsRepository extends CrudRepository<Aliments, Long> {
    @Query(value = "SELECT SUM(total_cal) FROM Aliments", nativeQuery = true)
    Integer selectTotals();
}
