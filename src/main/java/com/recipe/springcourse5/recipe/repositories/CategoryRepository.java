package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
