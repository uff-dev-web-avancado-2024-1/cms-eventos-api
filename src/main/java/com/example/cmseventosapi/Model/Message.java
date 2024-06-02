package com.example.cmseventosapi.Model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "message")
@Schema(description = "Modelo que representa uma mensagem")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da mensagem", example = "1")
    private Long id;

    @Schema(description = "conteudo da mensagem", example = "Palestra sobre Spring Boot")
    @Column(nullable = false)
    private String content;

    @Schema(description = "remetente da mensagem", example = "João da Silva")
    @Column(nullable = false,updatable = false)
    private Long sender;

    @Schema(description = "receptor da mensagem", example = "Pedro da Silva")
    @Column(nullable = false,updatable = false)
    private Long receiver;

}
