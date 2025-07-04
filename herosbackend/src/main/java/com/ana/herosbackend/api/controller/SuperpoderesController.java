package com.ana.herosbackend.api.controller;

import com.ana.herosbackend.api.ExceptionHandler.ExceptionMessage;
import com.ana.herosbackend.application.service.SuperpoderService;
import com.ana.herosbackend.domain.model.Herois;
import com.ana.herosbackend.domain.model.Superpoderes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Superpoderes")
@RestController
@RequestMapping("/superpoderes")
public class SuperpoderesController {

    @Autowired
    private SuperpoderService superpoderesService;
    @Operation(summary = "Buscar todos os Superpoderes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Superpoderes.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))})
    })
    @GetMapping
    public ResponseEntity<List<Superpoderes>> getHerois() {
        return ResponseEntity.status(HttpStatus.OK).body(superpoderesService.buscarSuperpoderes());
    }
}
