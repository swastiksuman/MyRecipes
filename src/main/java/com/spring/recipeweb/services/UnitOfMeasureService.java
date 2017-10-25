package com.spring.recipeweb.services;

import java.util.Set;

import com.spring.recipeweb.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}