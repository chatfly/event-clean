package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;

public class filtroIdentificadorUsecaseImpl implements filtroIdentificadorUsecase {

    private final EventoGateway eventoGateway;

    public filtroIdentificadorUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.filtroIdentificador(identificador);
    }

}
