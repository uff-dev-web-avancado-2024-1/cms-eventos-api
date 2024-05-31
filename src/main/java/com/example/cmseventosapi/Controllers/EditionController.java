package com.example.cmseventosapi.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/Edição")
@Tag(name = "cms-edições-api")
public class EditionController {
    @GetMapping
    @Operation(summary = "")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @Operation(summary = "Cadastra uma nova edição de evento", method = "POST")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro de edição realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros para cadastro de edição inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao cadastrar edição")
        })
        @PostMapping
        public ResponseEntity<String> cadastrarEdicao(@RequestBody String edition) {
            //TODO: process POST request
            return ResponseEntity.ok("Edição cadastrada com sucesso");
        }

    @Operation(summary = "Cadastra um organizador para uma edição", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Organizador cadastrado com sucesso na edição"),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
        @ApiResponse(responseCode = "404", description = "Edição não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro ao cadastrar organizador")
    })
    @PostMapping("/{editionId}/organizers")
    public ResponseEntity<String> addOrganizerToEdition(@PathVariable Long editionId, @RequestBody String organizer) {
        return ResponseEntity.ok("Organizador cadastrado com sucesso na edição");
    }
}
