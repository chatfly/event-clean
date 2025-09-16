package dev.java10x.EventClean.infrastructure.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.mapper.EventoEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.EventoEntity;
import dev.java10x.EventClean.infrastructure.persistence.EventoRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository eventoRepository;
    private final EventoEntityMapper eventoEntityMapper;

    public EventoRepositoryGateway(EventoRepository eventoRepository, EventoEntityMapper eventoEntityMapper) {
        this.eventoRepository = eventoRepository;
        this.eventoEntityMapper = eventoEntityMapper;
    }

    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity entity = eventoEntityMapper.map(evento);
        EventoEntity novoEvento = eventoRepository.save(entity);
        return eventoEntityMapper.map(novoEvento);
    }

    @Override
    public List<Evento> listarEventos() {
        List<EventoEntity> eventos = eventoRepository.findAll();
        return eventos.stream()
                .map(eventoEntityMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        return eventoRepository.findAll().stream()
                .anyMatch(evento -> evento.getIdentificador().equals(identificador));
    }

    @Override
    public Evento filtroIdentificador(String identificador) {
        return eventoRepository.findByIdentificador(identificador);
    }

    @Override
    public String criarIdentificador() {
        StringBuilder id = new StringBuilder();
        for(int i = 0; i<3;  i++)
        {
            Random r = new Random();
            id.append((char) (r.nextInt(26) + 'a'));
        }
        for(int i = 0; i<3; i++)
        {
            id.append((int) (Math.random() * 10));
        }
        return id.toString().toUpperCase();
    }
}
