package com.example.cmseventosapi.Controllers;

import com.example.cmseventosapi.Model.Space;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/espacos")
@Tag(name = "Espaco")
public class SpaceController {

    @Operation(summary = "Cadastrar espaço disponivel", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Espaço cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos para o cadastro do espaço"),
        @ApiResponse(responseCode = "500", description = "Erro ao cadastrar espaço")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Space> cadastrarEspacoDisponivel(@RequestBody Space espaco) {
        //TODO: process POST request     
        return new ResponseEntity<>(new Space(),HttpStatus.OK);
    }

    @Operation(summary = "Editar espaço disponivel", method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Espaço atualizado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos para a atualização do espaço"),
        @ApiResponse(responseCode = "500", description = "Erro ao atualizar o espaço")
    })
    @PutMapping("/{espaco}")
    public ResponseEntity<Space> editarEspacoDisponivel(@PathVariable("espaco") Long espaco_id, @RequestBody Space espacoAtualizado) {
        //TODO: process POST request     
        return new ResponseEntity<>(new Space(),HttpStatus.OK);

    }
    @Operation(summary = "Remove Espaço",method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Remoção de espaco realizada com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para remoção de espaco inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao remover espaco")
    })
    @DeleteMapping("/{espaco}")
    public ResponseEntity<HttpStatus> removeEspaco(@PathVariable("espaco") String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}