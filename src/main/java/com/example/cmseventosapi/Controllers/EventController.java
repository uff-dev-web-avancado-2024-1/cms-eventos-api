package com.example.cmseventosapi.Controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;


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
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de evento inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar evento")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> cadastrarEvento(@RequestPart MultipartFile file) {
        //TODO: process POST request
        
        return new ResponseEntity<>(null);
    }
    @Operation(summary = "Atualiza Eventos",method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Atualização de evento realizada com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para atualização de evento inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao ataulizar evento")
    })
    @PutMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }

    @DeleteMapping
    public String requestMethodName(@RequestParam String param) {
        return new String();
    }

}
