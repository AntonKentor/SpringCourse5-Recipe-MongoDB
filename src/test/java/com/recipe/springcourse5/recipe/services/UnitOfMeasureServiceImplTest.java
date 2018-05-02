package com.recipe.springcourse5.recipe.services;

import com.recipe.springcourse5.recipe.models.UnitOfMeasure;
import com.recipe.springcourse5.recipe.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitOfMeasureServiceImplTest {

    private UnitOfMeasureService unitOfMeasureService;
    @Mock
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureRepository);
    }

    @Test
    public void listAllUoms() {
        Set<UnitOfMeasure> unitOfMeasureList = new HashSet<>();
        UnitOfMeasure unitOfMeasure1 = new UnitOfMeasure();
        unitOfMeasure1.setId(1L);

        UnitOfMeasure unitOfMeasure2 = new UnitOfMeasure();
        unitOfMeasure2.setId(2L);

        UnitOfMeasure unitOfMeasure3 = new UnitOfMeasure();
        unitOfMeasure3.setId(3L);

        unitOfMeasureList.add(unitOfMeasure1);
        unitOfMeasureList.add(unitOfMeasure2);
        unitOfMeasureList.add(unitOfMeasure3);

        when(unitOfMeasureService.listAllUoms()).thenReturn(unitOfMeasureList);
        Set<UnitOfMeasure> unitOfMeasures = unitOfMeasureService.listAllUoms();

        assertEquals(3, unitOfMeasures.size());
        verify(unitOfMeasureRepository, times(1)).findAll();

    }
}