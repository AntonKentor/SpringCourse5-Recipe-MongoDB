package com.recipe.springcourse5.recipe.services;

import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

public interface ImageService {
    Mono<Void> saveImageFile(String recipeId, MultipartFile multipartFile);
}
