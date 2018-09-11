package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.models.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryRepositoryIT {

    @Autowired
    CategoryRepository categoryRepository;

    @Before
    public void setup() throws Exception {
        categoryRepository.deleteAll().block();
    }

    @Test
    public void testSave() throws Exception {

        Category category = new Category();
        category.setDescription("foo");

        categoryRepository.save(category).block();
        Long count = categoryRepository.count().block();

        assertEquals(Long.valueOf(1l), count);
    }

    @Test
    public void testFindByDescription() throws Exception {
        Category category = new Category();
        category.setDescription("foo");

        categoryRepository.save(category).then().block();

        Category fetchedCategory = categoryRepository.findByDescription("foo").block();

        assertNotNull(fetchedCategory.getId());
    }

}