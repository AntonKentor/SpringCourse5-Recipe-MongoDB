package com.recipe.springcourse5.recipe.services;


import com.recipe.springcourse5.recipe.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
