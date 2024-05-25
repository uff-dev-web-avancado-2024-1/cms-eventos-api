package com.example.cmseventosapi.Model;

import com.example.cmseventosapi.Enum.ActivityType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "activities")
@Schema(description = "Modelo que representa uma atividade")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da atividade", example = "1")
    private Long id;

    @Schema(description = "Nome da atividade", example = "Palestra sobre Spring Boot")
    @Column(nullable = false)
    private String name;

    @Schema(description = "Tipo da atividade", example = "LECTURE")
    @Column(nullable = false)
    private ActivityType type;

    @Schema(description = "Descrição da atividade", example = "Uma palestra sobre Spring Boot")
    @Column(nullable = false)
    private String description;

    @Schema(description = "Data da atividade", example = "2023-01-02")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Schema(description = "Horário inicial da atividade", example = "09:00")
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Schema(description = "Horário final da atividade", example = "10:00")
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date endTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "space_id", nullable = false)
    @Schema(description = "Espaço onde a atividade ocorre")
    private Space space;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edition_id", nullable = false)
    @Schema(description = "Edição associada à atividade")
    private Edition edition;


    @ManyToMany(mappedBy = "favoriteActivities", fetch = FetchType.LAZY)
    @Schema(description = "Lista de usuários que favoritaram a atividade")
    private List<User> favoritedByUsers;
}
