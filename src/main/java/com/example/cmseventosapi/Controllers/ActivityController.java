package com.example.cmseventosapi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.cmseventosapi.Model.Activity;
import com.example.cmseventosapi.Services.ActivityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;





@RestController
@RequestMapping("/api/atividades")
@Tag(name = "Atividade")
public class ActivityController {
    
    @Autowired
    private ActivityService service;

    @Operation(summary = "Visualiza Atividade",method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Visualização de atividade realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para visualização de atividade inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao visualizar identidade atividade")
    })
    @GetMapping("/{atividade}")
    public ResponseEntity<Activity> vizualizaAtividade(@PathParam("atividade") Long id) {
        return new ResponseEntity<>(this.service.GetActivity(id),HttpStatus.OK);
    }

    @Operation(summary = "Cadastra Atividades",method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Cadastro de atividade realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de atividade inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar atividade")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Activity> cadastraAtividade(@RequestBody Activity atividade) {
        return new ResponseEntity<>(this.service.CreateActivity(atividade),HttpStatus.OK);
    }

    @Operation(summary = "Atualiza Atividades",method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Atualização de atividade realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para atualização de atividade inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao atualizar atividade")
    })
    @PutMapping("/{atividade}")
    public ResponseEntity<Activity> atualizaAtividade(@PathVariable("atividade") Long atividade_id, @RequestBody Activity atividadeAtualizada) {
        return new ResponseEntity<>(this.service.UpdateActivity(atividadeAtualizada, atividade_id),HttpStatus.OK);
    }

    @Operation(summary = "Remove Atividade",method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Remoção de atividade realizada com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para remoção de atividade inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao remover atividade")
    })
    @DeleteMapping("/{atividade}")
    public ResponseEntity<HttpStatus> removeAtividade(@PathVariable("atividade") Long id) {
        this.service.DeleteActivity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
}
