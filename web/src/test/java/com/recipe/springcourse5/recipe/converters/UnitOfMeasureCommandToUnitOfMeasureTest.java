package com.recipe.springcourse5.recipe.converters;

import com.recipe.springcourse5.recipe.commands.UnitOfMeasureCommand;
import com.recipe.springcourse5.recipe.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static com.recipe.springcourse5.recipe.TestConstants.DESCRIPTION;
import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    private static final String LONG_VALUE = "1";
    private UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();

    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId("1");
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals("1", uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());

    }

}