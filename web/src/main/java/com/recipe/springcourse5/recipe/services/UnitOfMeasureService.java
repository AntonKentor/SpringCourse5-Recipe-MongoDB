package com.recipe.springcourse5.recipe.services;


import com.recipe.springcourse5.recipe.commands.UnitOfMeasureCommand;
import reactor.core.publisher.Flux;

public interface UnitOfMeasureService {

    Flux<UnitOfMeasureCommand> listAllUoms();
}
