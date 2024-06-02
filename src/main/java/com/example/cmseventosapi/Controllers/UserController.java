package com.example.cmseventosapi.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;


@RestController
@RequestMapping("/api/Usuario")
@Tag(name = "cms-usuário-api")
public class UserController {

    @Operation(summary = "Cadastra novo usuário", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Cadastro de usuário realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de usuário inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar usuário")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public String cadastrarUsuario(@RequestBody String entity){
        // TODO Implementar os métodos para cadastrar usuário
        return entity;
    }

    @Operation(summary = "Enviar mensagem com atividades favoritas", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Mensagem enviada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro ao enviar mensagem")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> enviarMesagemFavoritas(@RequestPart MultipartFile file) {
        //TODO: process POST request     
        return new ResponseEntity<>(null);
    }


}
