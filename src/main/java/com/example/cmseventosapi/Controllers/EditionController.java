package com.example.cmseventosapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cmseventosapi.Model.Edition;
import com.example.cmseventosapi.Services.EditionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/edicao")
@Tag(name = "Edição")
public class EditionController {

    @Autowired
    private EditionService service;

    @Operation(summary = "Cadastra Edição",method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Cadastro de edição realizada com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de edição inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar edição")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Edition> cadastraEdicao(@RequestBody Edition edicao) {        
        return new ResponseEntity<>(this.service.CreateEdition(edicao),HttpStatus.OK);
    }
    
    @Operation(summary = "Atualiza Edição",method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Atualização de edição realizada com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para atualização de edição inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao atualizar edição")
    })
    @PutMapping("/{edicao}")
    public ResponseEntity<Edition> atualizaEdicao(@PathVariable("edicao") Long edicao_id, @RequestBody Edition edicaoAtualizado) {     
        return new ResponseEntity<>(this.service.UpdateEdition(edicaoAtualizado, edicao_id),HttpStatus.OK);
    }

    @Operation(summary = "Remove Edição",method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Remoção de edição realizada com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para remoção de edição inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao remover edição")
    })
    @DeleteMapping("/{edicao}")
    public ResponseEntity<HttpStatus> removeEdicao(@PathVariable("edicao") Long id) {
        this.service.DeleteEdition(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
