package com.recipe.springcourse5.recipe.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Notes {

    @Id
    private String id;
    private String recipeNotes;
}
