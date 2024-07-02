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

    @OneToMany
    @JoinTable(
            name = "user_organized_editions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "edition_id")
    )
    @Schema(description = "Lista de edições organizadas pelo usuário")
    private List<Edition> organizedEditions;

    @Schema(description = "Se o usuário é administrador", example = "true")
    private boolean isAdmin;

    @Schema(description = "Senha do usuário", example = "123456")
    private String password;

    public boolean isUserOrganizer(Long editionId) {
        for (Edition edition : this.organizedEditions) {
            if (edition.getId().equals(editionId)) {
                return true;
            }
        }
        return false;
    }
}
