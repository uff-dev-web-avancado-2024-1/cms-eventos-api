package com.example.cmseventosapi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;





@RestController
@RequestMapping("/api/Atividade")
@Tag(name = "cms-eventos-api")
public class ActivityController {
    
    @GetMapping
    @Operation(summary = "")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @Operation(summary = "Cadastra Atividades",method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Cadastro de atividade realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de atividade inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar atividade")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
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
    
    
    
}
