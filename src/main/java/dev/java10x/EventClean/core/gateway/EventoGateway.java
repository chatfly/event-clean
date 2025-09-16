package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entities.Evento;

import java.util.List;

public interface EventoGateway {

    public Evento criarEvento(Evento evento);
    public List<Evento> listarEventos();
    boolean existePorIdentificador(String identificador);
    public Evento filtroIdentificador(String identificador);
    public String criarIdentificador();

}
