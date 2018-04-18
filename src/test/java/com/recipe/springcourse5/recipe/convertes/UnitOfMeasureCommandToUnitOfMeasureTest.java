package com.recipe.springcourse5.recipe.convertes;

import com.recipe.springcourse5.recipe.commands.UnitOfMeasureCommand;
import com.recipe.springcourse5.recipe.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static com.recipe.springcourse5.recipe.TestConstants.DESCRIPTION;
import static com.recipe.springcourse5.recipe.TestConstants.LONG_ID_VALUE;
import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() {
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setDescription(DESCRIPTION);
        unitOfMeasureCommand.setId(LONG_ID_VALUE);

        UnitOfMeasure convertedUnitOfMeasure = converter.convert(unitOfMeasureCommand);

        assertNotNull(convertedUnitOfMeasure);
        assertEquals(convertedUnitOfMeasure.getId(), LONG_ID_VALUE);
        assertEquals(convertedUnitOfMeasure.getDescription(), DESCRIPTION);
    }
}