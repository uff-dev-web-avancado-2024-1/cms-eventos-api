package com.example.cmseventosapi.Controllers;

import javax.print.attribute.standard.Media;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.media.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/api/evento")
@Tag(name = "cms-eventos-api")
public class EventController {
    
    @GetMapping
    @Operation(summary = "")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @Operation(summary = "Cadastra Eventos",method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Cadastro de evento realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de de evento inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar evento")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> cadastrarEvento(@RequestPart MultipartFile file) {
        //TODO: process POST request
        
        return file;
    }

    @PutMapping
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }

    @DeleteMapping
    public String requestMethodName(@RequestParam String param) {
        return new String();
    }

    @Operation(summary = "Visualizar página do evento",method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Busca de evento feita com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametros para busca de evento inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao buscar evento")
    })
    @GetMapping("{eventoId}/edicoes/{edicaoAno}")
    public String visualizarEvento(@PathVariable long eventoId, @PathVariable long edicaoAno){
         // TODO Implementar os métodos para cadastrar usuário
        return "Evento de id: " + eventoId + " Edição: " + edicaoAno;
    }

}
