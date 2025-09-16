package dev.java10x.EventClean.infrastructure.beans;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.core.usecases.*;
import dev.java10x.EventClean.infrastructure.gateway.EventoRepositoryGateway;
import dev.java10x.EventClean.infrastructure.mapper.EventoEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.EventoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public criarEventoUsecase criarEvento(EventoGateway eventoGateway){
        return new criarEventoUsecaseImpl(eventoGateway);
    }

    @Bean
    public buscarEventoUsecase buscarEvento(EventoGateway eventoGateway){
        return new buscarEventoUsecaseImpl(eventoGateway);
    }

    @Bean
    public EventoGateway eventoGateway(EventoRepository eventoRepository, EventoEntityMapper eventoEntityMapper){
        return new EventoRepositoryGateway(eventoRepository, eventoEntityMapper);
    }

    @Bean
    public filtroIdentificadorUsecase filtroIdentificador(EventoGateway eventoGateway) {
        return new filtroIdentificadorUsecaseImpl(eventoGateway);
    }

    @Bean
    public criarIdentificadorUsecase criarIdentificador(EventoGateway eventoGateway) {
        return new criarIdentificadorUsecaseImpl(eventoGateway);
    }

}
