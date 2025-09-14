package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;

public interface filtroIdentificadorUsecase {
    public Evento execute(String identificador);
}
