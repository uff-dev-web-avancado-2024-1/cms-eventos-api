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

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    @Schema(description = "remetente da mensagem", example = "João da Silva")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    @Schema(description = "receptor da mensagem", example = "Pedro da Silva")
    private User receiver;

}
