package dev.java10x.EventClean.infrastructure.presentation;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.usecases.buscarEventoUsecase;
import dev.java10x.EventClean.core.usecases.criarEventoUsecase;
import dev.java10x.EventClean.core.usecases.filtroIdentificadorUsecase;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.exceptions.DuplicateEventException;
import dev.java10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final criarEventoUsecase criarEventoUsecase;
    private final buscarEventoUsecase buscarEventoUsecase;
    private final EventoDtoMapper eventoDtoMapper;
    private final filtroIdentificadorUsecase filtroIdentificadorUsecase;

    public EventoController(criarEventoUsecase criarEventoUsecase, buscarEventoUsecase buscarEventoUsecase, EventoDtoMapper eventoDtoMapper, filtroIdentificadorUsecase filtroIdentificadorUsecase) {
        this.criarEventoUsecase = criarEventoUsecase;
        this.buscarEventoUsecase = buscarEventoUsecase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.filtroIdentificadorUsecase = filtroIdentificadorUsecase;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto eventoDto) {
        Evento novoEvento = criarEventoUsecase.execute(eventoDtoMapper.map(eventoDto));
        Map<String, Object> response = new HashMap<>();
        response.put("messsage", "Evento cadastrado com sucesso no nosso banco de dados.");
        response.put("event", eventoDtoMapper.map(novoEvento));
        return ResponseEntity.ok(response);
    }

    @GetMapping("listareventos")
    public List<EventoDto> listarEventos() {
        return buscarEventoUsecase.execute().stream()
                .map(eventoDtoMapper::map)
                .collect(Collectors.toList());
    }

    @GetMapping("buscar/{identificador}")
    public ResponseEntity<Map<String, Object>> filtrarPorIdentificador(@PathVariable String identificador)
    {
        Evento eventoEncontrado = filtroIdentificadorUsecase.execute(identificador);
        if(eventoEncontrado != null)
        {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Evento encontrado com sucesso.");
            response.put("event", eventoEncontrado);
            return ResponseEntity.ok(response);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Evento não encontrado.");
        return ResponseEntity.ok(response);

    }

}
