package com.example.cmseventosapi.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "spaces")
@Getter
@Setter
@Schema(description = "Modelo que representa um espaço")
public class Space {
    @Id
    private Long id;

    @Schema(description = "Nome do espaço", example = "Auditório")
    @Column(nullable = false)
    private String name;

    @Schema(description = "Descrição do espaço", example = "Um auditório com capacidade para 100 pessoas")
    @Column(nullable = false)
    private String description;

    @Schema(description = "Capacidade do espaço", example = "100")
    @Column(nullable = false)
    private Integer capacity;

    @ElementCollection
    @CollectionTable(name = "space_resources", joinColumns = @JoinColumn(name = "space_id"))
    @Column(name = "resource")
    @Schema(description = "Lista de recursos disponíveis no espaço", example = "[\"Projetor\", \"Wi-Fi\"]")
    private List<String> resources;
}
