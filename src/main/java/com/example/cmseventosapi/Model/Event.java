package com.example.cmseventosapi.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "events")
@Schema(description = "Modelo que representa um evento")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do evento", example = "1")
    private Long id;

    @Schema(description = "Nome do evento", example = "Spring Boot Conference")
    @Column(nullable = false)
    private String name;

    @Schema(description = "Descrição do evento", example = "Uma conferência sobre Spring Boot")
    @Column(nullable = false)
    private String description;

    @Schema(description = "Sigla do evento", example = "SBC")
    @Column(nullable = false)
    private String acronym;

    @Schema(description = "Caminho do evento", example = "/conferences/spring-boot")
    @Column(nullable = false)
    private String path;



}