package com.example.cmseventosapi.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/api/Usuario")
@Tag(name = "Usuário")
public class UserController {

    @Operation(summary = "Cadastrar novo usuário", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Cadastro de usuário realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de usuário inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar usuário")
    })
    @PostMapping("/")
    public String cadastrarUsuario(){
        // TODO Implementar os métodos para cadastrar usuário
        return "Usuário cadastrado com Sucesso";
    }



}
