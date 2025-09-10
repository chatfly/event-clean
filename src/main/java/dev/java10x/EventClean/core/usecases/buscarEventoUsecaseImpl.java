package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class buscarEventoCaseImpl implements buscarEventoCase {

    private final EventoGateway eventoGateway;

    public buscarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute(Long id) {
        return eventoGateway.listarEventos();
    }

}
