package dev.java10x.EventClean.infrastructure.persistence;

import dev.java10x.EventClean.core.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
    Evento findByIdentificador(String identificador);
}
