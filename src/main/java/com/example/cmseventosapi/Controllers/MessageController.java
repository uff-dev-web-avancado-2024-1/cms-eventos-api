package com.example.cmseventosapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cmseventosapi.Model.Message;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/message")
@Tag(name = "Message")
public class MessageController {
    @Operation(summary = "Cadastra novo mensagem", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Cadastro de mensagem realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de mensagem inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar mensagem")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Message> enviarMesagemFavoritas(@RequestBody Message mensagem){
        // TODO Implementar os métodos para cadastrar usuário
        return new ResponseEntity<>(new Message(),HttpStatus.OK);
    }
}
