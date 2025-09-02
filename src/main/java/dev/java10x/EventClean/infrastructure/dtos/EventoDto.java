package dev.java10x.EventClean.infrastructure.dtos;

import dev.java10x.EventClean.core.enums.TipoEvento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventoDto
{
    public Long id;
    public String nome;
    public String descricao;
    public String identificador;
    public LocalDateTime dataInicio;
    public LocalDateTime dataFim;
    public String localEvento;
    public Integer capacidade;
    public String organizador;
    public TipoEvento tipo;
}
