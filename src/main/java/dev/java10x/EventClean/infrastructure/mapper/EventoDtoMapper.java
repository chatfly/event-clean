package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.persistence.EventoEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoDtoMapper {

    public EventoEntity map(EventoDto dto)
    {
        EventoEntity entity = new EventoEntity();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setIdentificador(dto.getIdentificador());
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataFim(dto.getDataFim());
        entity.setLocalEvento(dto.getLocalEvento());
        entity.setOrganizador(dto.getOrganizador());
        entity.setCapacidade(dto.getCapacidade());
        entity.setTipo(dto.getTipo());
        return entity;
    }

    public EventoDto map(EventoEntity entity)
    {
        EventoDto dto = new EventoDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setIdentificador(entity.getIdentificador());
        dto.setDataInicio(entity.getDataInicio());
        dto.setDataFim(entity.getDataFim());
        dto.setLocalEvento(entity.getLocalEvento());
        dto.setOrganizador(entity.getOrganizador());
        dto.setCapacidade(entity.getCapacidade());
        dto.setTipo(entity.getTipo());
        return dto;
    }

}
