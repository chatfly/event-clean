package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.persistence.EventoEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoDtoMapper {

    public Evento map(EventoDto dto)
    {
        return new Evento(
                dto.getId(),
                dto.getNome(),
                dto.getDescricao(),
                dto.getIdentificador(),
                dto.getDataInicio(),
                dto.getDataFim(),
                dto.getLocalEvento(),
                dto.getCapacidade(),
                dto.getOrganizador(),
                dto.getTipo()
        );
    }

    public EventoDto map(Evento evento)
    {
        EventoDto dto = new EventoDto();
        dto.setId(evento.id());
        dto.setNome(evento.nome());
        dto.setDescricao(evento.descricao());
        dto.setIdentificador(evento.identificador());
        dto.setDataInicio(evento.dataInicio());
        dto.setDataFim(evento.dataFim());
        dto.setLocalEvento(evento.localEvento());
        dto.setOrganizador(evento.organizador());
        dto.setCapacidade(evento.capacidade());
        dto.setTipo(evento.tipo());
        return dto;
    }

}
