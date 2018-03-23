package com.recipe.springcourse5.recipe.models;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    private @Getter @Setter String description;

}
