package com.coffeeDemo.repository;

import com.coffeeDemo.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends BaseRepository<Coffee, Long> {
}
