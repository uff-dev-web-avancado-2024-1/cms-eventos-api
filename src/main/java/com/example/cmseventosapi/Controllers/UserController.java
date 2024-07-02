package com.example.cmseventosapi.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cmseventosapi.Model.User;
import com.example.cmseventosapi.Services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuário")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Cadastra novo usuário", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Cadastro de usuário realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de usuário inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar usuário")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> cadastrarUsuario(@RequestBody User usuario){
        return new ResponseEntity<>(this.service.createUser(usuario),HttpStatus.OK);
    }

    @Operation(summary = "Atualiza novo usuário", method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Atualiza de usuário realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para atualização de usuário inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao atualizar usuário")
    })
    @PutMapping("/{usuario}")
    public ResponseEntity<User> atualizaUsuario(@PathVariable("usuario") Long usuario_id, @RequestBody User usuarioAtualizado){
        return new ResponseEntity<>(this.service.updateUser(usuarioAtualizado, usuario_id),HttpStatus.OK);
    }

    @Operation(summary = "Torna usuário administrador", method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Usuário promovido a administrador com sucesso"),
        @ApiResponse(responseCode = "403",description = "O usuário deve ser administrador para realizar essa ação"),
        @ApiResponse(responseCode = "500",description = "Erro ao promover usuário a administrador")
    })
    @PutMapping("/{usuario}/admin")
    public ResponseEntity<User> tornaAdmin(@PathVariable("usuario") Long usuario_id){
        return new ResponseEntity<>(this.service.makeAdmin(usuario_id),HttpStatus.OK);
}}
