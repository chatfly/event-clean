package dev.java10x.EventClean.infrastructure.presentation;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.usecases.buscarEventoUsecase;
import dev.java10x.EventClean.core.usecases.criarEventoUsecase;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final criarEventoUsecase criarEventoUsecase;
    private final buscarEventoUsecase buscarEventoUsecase;
    private final EventoDtoMapper eventoDtoMapper;

    public EventoController(criarEventoUsecase criarEventoUsecase, buscarEventoUsecase buscarEventoUsecase, EventoDtoMapper eventoDtoMapper) {
        this.criarEventoUsecase = criarEventoUsecase;
        this.buscarEventoUsecase = buscarEventoUsecase;
        this.eventoDtoMapper = eventoDtoMapper;
    }

    @PostMapping("criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto eventoDto) {
        Evento novoEvento = criarEventoUsecase.execute(eventoDtoMapper.map(eventoDto));
        return eventoDtoMapper.map(novoEvento);
    }

    @GetMapping("listareventos")
    public List<EventoDto> listarEventos() {
        return buscarEventoUsecase.execute().stream()
                .map(eventoDtoMapper::map)
                .collect(Collectors.toList());
    }

}
