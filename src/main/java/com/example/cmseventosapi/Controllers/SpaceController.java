package com.example.cmseventosapi.Controllers;

import com.example.cmseventosapi.Model.Requests.CreateSpaceReq;
import com.example.cmseventosapi.Model.Space;
import com.example.cmseventosapi.Services.SpaceService;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SpaceService service;

    @Operation(summary = "Cadastrar espaço disponivel", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Espaço cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos para o cadastro do espaço"),
        @ApiResponse(responseCode = "500", description = "Erro ao cadastrar espaço")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Space> cadastrarEspacoDisponivel(@RequestBody CreateSpaceReq createSpaceReq) {
        if (createSpaceReq == null || createSpaceReq.getName() == null || createSpaceReq.getDescription() == null || createSpaceReq.getResources() == null){
            throw new IllegalArgumentException("Parâmetros inválidos para o cadastro do espaço");
        }
            return new ResponseEntity<>(this.service.CreateSpace(createSpaceReq),HttpStatus.OK);
    }

    @Operation(summary = "Editar espaço disponivel", method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Espaço atualizado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos para a atualização do espaço"),
        @ApiResponse(responseCode = "500", description = "Erro ao atualizar o espaço")
    })
    @PutMapping("/{espaco}")
    public ResponseEntity<Space> editarEspacoDisponivel(@PathVariable("espaco") Long espaco_id, @RequestBody Space espacoAtualizado) {
        return new ResponseEntity<>(this.service.UpdateSpace(espacoAtualizado, espaco_id),HttpStatus.OK);

    }
    @Operation(summary = "Remove Espaço",method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Remoção de espaco realizada com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para remoção de espaco inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao remover espaco")
    })
    @DeleteMapping("/{espaco}")
    public ResponseEntity<HttpStatus> removeEspaco(@PathVariable("espaco") Long id) {
        this.service.DeleteSpace(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}