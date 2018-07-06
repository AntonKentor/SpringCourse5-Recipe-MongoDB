package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.models.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    UserInfo findByUserName(String userName);

}
