
package com.security.security1.Repository;

import com.security.security1.Model.Food;

import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {

    Food findById(long id);
}