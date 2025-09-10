package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class buscarEventoUsecaseImpl implements buscarEventoUsecase {

    private final EventoGateway eventoGateway;

    public buscarEventoUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute() {
        return eventoGateway.listarEventos();
    }

}
