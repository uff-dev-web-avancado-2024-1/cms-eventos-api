package com.example.cmseventosapi.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
@Schema(description = "Modelo que representa um usuário")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do usuário", example = "1")
    private Long id;

    @Schema(description = "Nome do usuário", example = "João da Silva")
    @Column(nullable = false)
    private String name;

    @Schema(description = "Email do usuário", example = "joaosilva@email.com")
    @Column(nullable = false)
    private String email;

    @Schema(description = "Login do usuário", example = "joaosilva")
    private String login;

    @Schema(description = "Afiliação do usuário", example = "Universidade Federal de Santa Catarina")
    private String affiliation;

    @ManyToMany
    @JoinTable(
            name = "user_favorite_activities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    @Schema(description = "Lista de atividades favoritas do usuário")
    private List<Activity> favoriteActivities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edition_id", nullable = false)
    @Schema(description = "Edição associada à atividade")
    private Edition edition;

}
