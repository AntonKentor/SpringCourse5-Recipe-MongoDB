package com.recipe.springcourse5.recipe.services;

import com.recipe.springcourse5.recipe.models.UnitOfMeasure;
import com.recipe.springcourse5.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired
    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public Set<UnitOfMeasure> listAllUoms() {
        Set<UnitOfMeasure> uoms = new HashSet<>();
        log.debug("in listAllUoms");
        unitOfMeasureRepository.findAll().iterator().forEachRemaining(uoms::add);
        return uoms;
    }
}
