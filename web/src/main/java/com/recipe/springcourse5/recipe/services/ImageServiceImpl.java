package com.recipe.springcourse5.recipe.services;


import com.recipe.springcourse5.recipe.models.Recipe;
import com.recipe.springcourse5.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;


@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    private RecipeRepository recipeRepository;

    @Override
    public Mono<Void> saveImageFile(String recipeId, MultipartFile multipartFile) {

        Mono<Recipe> recipeMono = recipeRepository.findById(recipeId)
                .map(recipe -> {
                    Byte[] byteOfObjects = new Byte[0];
                    try {
                        byteOfObjects = new Byte[multipartFile.getBytes().length];

                        int i = 0;

                        for (byte b : byteOfObjects) {
                            byteOfObjects[i++] = b;
                        }
                        recipe.setImage(byteOfObjects);
                        return recipe;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        throw new RuntimeException(ex);
                    }
                });
        recipeRepository.save(recipeMono.block()).block();
        return Mono.empty();
    }
}
