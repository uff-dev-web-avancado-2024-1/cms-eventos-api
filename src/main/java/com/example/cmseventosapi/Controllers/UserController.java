package com.example.cmseventosapi.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cmseventosapi.Model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/usuario")
@Tag(name = "cms-usuário-api")
public class UserController {

    @Operation(summary = "Cadastra novo usuário", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Cadastro de usuário realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de usuário inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar usuário")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> cadastrarUsuario(@RequestBody User usuario){
        // TODO Implementar os métodos para cadastrar usuário
        return new ResponseEntity<>(new User(),HttpStatus.OK);
    }

    @Operation(summary = "Atualiza novo usuário", method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Atualiza de usuário realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para atualização de usuário inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao atualizar usuário")
    })
    @PutMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> atualizaUsuario(@RequestBody User usuario){
        // TODO Implementar os métodos para cadastrar usuário
        return new ResponseEntity<>(new User(),HttpStatus.OK);
    }
}
