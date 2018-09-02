package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.models.UserInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserInfoRepository extends ReactiveMongoRepository<UserInfo, String> {

    UserInfo findByUserName(String userName);

}
