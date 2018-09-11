package com.recipe.springcourse5.recipe.services;


import com.recipe.springcourse5.recipe.models.Recipe;
import com.recipe.springcourse5.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;


@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    private RecipeRepository recipeRepository;

    @Transactional
    @Override
    public void saveImageFile(String recipeId, MultipartFile multipartFile) {
        log.info("recieved a file");
        try {
            Recipe recipe = recipeRepository.findById(recipeId).block();

            Byte[] byteObjects = new Byte[multipartFile.getBytes().length];

            int i = 0;

            for (byte b : multipartFile.getBytes()) {
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);

            recipeRepository.save(recipe).block();
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}
