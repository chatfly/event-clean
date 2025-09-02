package dev.java10x.EventClean.infrastructure.persistence;

import dev.java10x.EventClean.core.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "eventos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EventoEntity{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String descricao;
        private String identificador;
        private LocalDateTime dataInicio;
        private LocalDateTime dataFim;
        private String localEvento;
        private Integer capacidade;
        private String organizador;
        @Enumerated(EnumType.STRING)
        private TipoEvento tipo;
}
