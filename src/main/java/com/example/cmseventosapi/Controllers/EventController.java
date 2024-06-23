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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.cmseventosapi.Model.Edition;
import com.example.cmseventosapi.Model.Event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/edicao")
@Tag(name = "cms-edições-api")
public class EditionController {

    @GetMapping
    @Operation(summary = "Obter método")
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
        // TODO: process POST request
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

    @Operation(summary = "Atualiza Edição", method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Atualização de edição realizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetros para atualização de edição inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao atualizar edição")
    })
    @PutMapping("/{edicao}")
    public ResponseEntity<Edition> atualizaEdicao(@PathVariable("edicao") Long edicao_id, @RequestBody Edition edicaoAtualizado) {
        // TODO: process PUT request
        return new ResponseEntity<>(new Edition(), HttpStatus.OK);
    }

    @Operation(summary = "Remove Edição", method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Remoção de edição realizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetros para remoção de edição inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao remover edição")
    })
    @DeleteMapping("/{edicao}")
    public ResponseEntity<HttpStatus> removeEdicao(@PathVariable("edicao") String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

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
