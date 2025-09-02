package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    @PostMapping("criarevento")
    public String criarEvento(@RequestBody EventoDto evento) {
        return "Evento criado";
    }

}
