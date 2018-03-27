package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);

}
