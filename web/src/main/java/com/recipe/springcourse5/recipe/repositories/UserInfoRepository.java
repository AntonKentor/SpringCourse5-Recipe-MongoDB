package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.models.UserInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, String> {

    UserInfo findByUserName(String userName);

}
