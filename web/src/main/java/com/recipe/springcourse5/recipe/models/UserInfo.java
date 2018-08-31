package com.recipe.springcourse5.recipe.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class UserInfo {

    @Id
    private String id;
    private String userName;
    private String password;
    private String firstname;
    private String lastName;
    private String role;
    private String country;
    private boolean enabled;
}