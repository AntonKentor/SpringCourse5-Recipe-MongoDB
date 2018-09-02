package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.models.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {

    Mono<Category> findByDescription(String description);

}
