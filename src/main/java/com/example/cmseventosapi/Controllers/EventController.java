package com.example.cmseventosapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cmseventosapi.Model.Event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/eventos")
@Tag(name = "Eventos")
public class EventController {

    @Operation(summary = "Visualiza Evento", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Visualização de evento realizado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetros para visualização de evento inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao visualizar identidade evento")
    })
    @GetMapping("/{evento}")
    public ResponseEntity<Event> vizualizaEvento(@PathParam("evento") String id) {
        return new ResponseEntity<>(new Event(), HttpStatus.OK);
    }

    @Operation(summary = "Cadastra Eventos", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cadastro de evento realizado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetros para cadastro de evento inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao cadastrar evento")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Event> cadastrarEvento(@RequestBody Event evento) {
        // TODO: process POST request
        return new ResponseEntity<>(new Event(), HttpStatus.OK);
    }

    @Operation(summary = "Atualiza Eventos", method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Atualização de evento realizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetros para atualização de evento inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao atualizar evento")
    })
    @PutMapping("/{evento}")
    public ResponseEntity<Event> atualizaEvento(@PathVariable("evento") Long evento_id, @RequestBody Event eventoAtualizado) {
        // TODO: process PUT request
        return new ResponseEntity<>(new Event(), HttpStatus.OK);
    }

    @Operation(summary = "Remove Eventos", method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Remoção de evento realizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetros para remoção de evento inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao remover evento")
    })
    @DeleteMapping("/{evento}")
    public ResponseEntity<HttpStatus> removeEvento(@PathVariable("evento") String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
