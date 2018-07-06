package com.recipe.springcourse5.recipe.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UserInfo {
    @Id
    private String userName;
    private String password;
    private String firstname;
    private String lastName;
    private String role;
    private String country;
    private boolean enabled;
}