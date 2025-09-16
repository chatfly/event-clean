package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.gateway.EventoGateway;

import java.util.Random;

public class criarIdentificadorUsecaseImpl implements criarIdentificadorUsecase {
    EventoGateway eventoGateway;

    public criarIdentificadorUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public String execute() {
        return eventoGateway.criarIdentificador();
    }
}
