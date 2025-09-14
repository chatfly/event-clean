package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exceptions.DuplicateEventException;

public class criarEventoUsecaseImpl implements criarEventoUsecase {

    private final EventoGateway eventoGateway;

    public criarEventoUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento){

        if(eventoGateway.existePorIdentificador(evento.identificador()))
        {
            throw new DuplicateEventException("O identificador: " + evento.identificador() + " já está em uso.");
        }

        return eventoGateway.criarEvento(evento);
    }

}
