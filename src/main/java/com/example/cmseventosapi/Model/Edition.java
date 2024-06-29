package com.example.cmseventosapi.Model;

import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Schema(description = "Modelo que representa uma edição")
@Table(name = "editions")
public class Edition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da edição", example = "1")
    private Long id;

    @Schema(description = "Número da edição", example = "1")
    @Column
    private Integer number;

    @Schema(description = "Ano da edição", example = "2021")
    @Column
    private Integer year;

    @Schema(description = "Data inicial da edição", example = "2023-01-01")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Schema(description = "Data final da edição", example = "2023-01-05")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "event_id", nullable = false)
    @Schema(description = "Evento associado à edição")
    private Event event;

    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "Atividades da edição")
    private List<Activity> activities;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    @Schema(description = "Organizador da edição")
    private User organizer;
}
