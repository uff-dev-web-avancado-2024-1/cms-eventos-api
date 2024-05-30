package com.example.cmseventosapi.Controllers;

import com.example.cmseventosapi.Model.Space;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/espaco")
@Tag(name = "cms-eventos-api")
public class SpaceController {

    @Operation(summary = "Cadastrar espaço disponivel", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Espaço cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos para o cadastro do espaço"),
        @ApiResponse(responseCode = "500", description = "Erro ao cadastrar espaço")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> cadastrarEspacoDisponivel(@RequestPart MultipartFile file) {
        //TODO: process POST request     
        return new ResponseEntity<>(null);
    }

}