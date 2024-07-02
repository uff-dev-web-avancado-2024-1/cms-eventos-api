package com.example.cmseventosapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cmseventosapi.Model.Event;
import com.example.cmseventosapi.Services.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/eventos")
@Tag(name = "Eventos")
public class EventController {

    @Autowired
    private EventService service;
    
    @Operation(summary = "Visualiza Evento",method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Visualização de evento realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para visualização de evento inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao visualizar identidade evento")
    })
    @GetMapping("/{evento}")
    public ResponseEntity<Event> vizualizaEvento(@PathParam("evento") Long id) {
        return new ResponseEntity<>(this.service.GetEvent(id),HttpStatus.OK);
    }

    @Operation(summary = "Cadastra Eventos",method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Cadastro de evento realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para cadastro de evento inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao cadastrar evento")
    })
    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> cadastrarEvento(@RequestBody Event evento) {
        if (evento == null || evento.getName() == null || evento.getDescription() == null || evento.getAcronym() == null || evento.getPath() == null){
            throw new IllegalArgumentException("Parâmetros inválidos para o cadastro do evento");
        }
            return new ResponseEntity<>(this.service.CreateEvent(evento),HttpStatus.OK);
    }
    @Operation(summary = "Atualiza Eventos",method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Atualização de evento realizada com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para atualização de evento inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao ataulizar evento")
    })
    @PutMapping("/{evento}")
    public ResponseEntity<Event> atualizaEvento(@PathVariable("evento") Long evento_id, @RequestBody Event eventoAtualizado) {
        return new ResponseEntity<>(this.service.UpdateEvent(eventoAtualizado, evento_id),HttpStatus.OK);
    }
    @Operation(summary = "Remove Eventos",method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Remoção de evento realizada com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para remoção de evento inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao remover evento")
    })
    @DeleteMapping("/{evento}")
    public ResponseEntity<HttpStatus> removeEvento(@PathVariable("evento") Long id) {
        this.service.DeleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
