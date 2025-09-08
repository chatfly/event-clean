package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;

public class criarEventoUsecaseImpl implements criarEventoUsecase {

    private final EventoGateway eventoGateway;

    public criarEventoUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento){
        return null;
    }

}
