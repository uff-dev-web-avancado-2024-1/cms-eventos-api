package com.example.cmseventosapi.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cmseventosapi.Model.Activity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;




@RestController
@RequestMapping("/api/atividade")
@Tag(name = "cms-atividade-api")

public class ActivityController {
    
    @Operation(summary = "Visualiza Atividade",method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Visualização de atividade realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para visualização de atividade inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao visualizar identidade atividade")
    })
    @GetMapping("/{atividade}")
    public ResponseEntity<Activity> vizualizaAtividade(@PathParam("atividade") String id) {
        return new ResponseEntity<>(new Activity(),HttpStatus.OK);
    }

    @Operation(summary = "Cadastra Atividades",method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Cadastro de atividade realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de atividade inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar atividade")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Activity> cadastraAtividade(@RequestBody Activity atividade) {
        //TODO: process POST request
        
        return new ResponseEntity<>(new Activity(),HttpStatus.OK);
    }

    @Operation(summary = "Atualiza Atividades",method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Atualização de atividade realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para atualização de atividade inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao atualizar atividade")
    })
    @PutMapping("/{atividade}")
    public ResponseEntity<Activity> atualizaAtividade(@PathVariable("atividade") Long atividade_id, @RequestBody Activity atividadeAtualizada) {
        //TODO: process PUT request
        
        return new ResponseEntity<>(new Activity(),HttpStatus.OK);
    }

    @Operation(summary = "Remove Atividade",method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Remoção de atividade realizada com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para remoção de atividade inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao remover atividade")
    })
    @DeleteMapping("/{atividade}")
    public ResponseEntity<HttpStatus> removeAtividade(@PathVariable("atividade") String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "Favorita uma atividade", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Atividade favoritada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Atividade não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro ao favoritar atividade")
    })
    @PostMapping(value = "/{id}/favoritar")
    public String favoritarAtividade(@PathVariable String id) {
        // TODO Implementar o método para favoritar uma atividade
        return "Atividade favoritada com sucesso";
    }
}
