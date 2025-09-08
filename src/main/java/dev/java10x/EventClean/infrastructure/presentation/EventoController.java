package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.usecases.CriarEventoUsecase;
import dev.java10x.EventClean.core.usecases.criarEventoUsecase;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final criarEventoUsecase criarEventoUsecase;
    private final EventoDtoMapper eventoDtoMapper;

    public EventoController(criarEventoUsecase criarEventoUsecase, EventoDtoMapper eventoDtoMapper) {
        this.criarEventoUsecase = criarEventoUsecase;
        this.eventoDtoMapper = eventoDtoMapper;
    }

    @PostMapping("criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto eventoDto) {
        Evento novoEvento = criarEventoUsecase.execute(eventoDtoMapper.map(eventoDto));
        return eventoDtoMapper.map(novoEvento);
    }

    @GetMapping("listareventos")
    public String listarEventos() {
        return "Eventos";
    }

}
