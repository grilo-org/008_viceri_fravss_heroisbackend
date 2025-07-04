package com.ana.herosbackend.api.controller;

import com.ana.herosbackend.api.ExceptionHandler.ExceptionMessage;
import com.ana.herosbackend.api.dtos.HeroiRecord;
import com.ana.herosbackend.application.service.HeroiService;
import com.ana.herosbackend.application.service.SuperpoderService;
import com.ana.herosbackend.domain.model.Herois;
import com.ana.herosbackend.domain.model.Superpoderes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Herois")
@RestController
@RequestMapping("/heroi")
public class HeroiController {

    @Autowired
    private HeroiService heroiService;

    @Autowired
    private SuperpoderService superpoderService;

    @Operation(summary = "Criar novo Heroi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "O heroi foi criado com sucesso", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Herois.class))}),
            @ApiResponse(responseCode = "409", description = "Já existe um herói com esse nome cadastrado", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))})
    })
    @PostMapping
    public ResponseEntity<Herois> saveHeroi(@RequestBody @Valid HeroiRecord heroiDto) {
        List<Superpoderes> superpoderesList = superpoderService.buscarSuperpoderes(heroiDto.superpoderIds());
        Herois heroi = new Herois();
        heroi.setSuperpoderes(superpoderesList);
        heroi.setNomeHeroi(heroiDto.nomeHeroi());
        heroi.setNome(heroiDto.nome());
        heroi.setAltura(heroiDto.altura());
        heroi.setPeso(heroiDto.peso());
        heroi.setDataNascimento(heroiDto.dataNascimento());

        return ResponseEntity.status(HttpStatus.CREATED).body(heroiService.salvar(heroi));
    }

    @Operation(summary = "Buscar Heroi por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Herois.class))}),
            @ApiResponse(responseCode = "409", description = "Já existe um herói com esse nome cadastrado", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))}),
            @ApiResponse(responseCode = "404", description = "Não existe um herói cadastrado com esse Id", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))}),
            @ApiResponse(responseCode = "400", description = "ID inválido", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))})
    })
    @GetMapping("/{id}")
    public ResponseEntity<Herois> getHeroiById(@PathVariable Long id) {
        Herois heroi = heroiService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(heroi);
    }

    @Operation(summary = "Buscar todos os Herois")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Herois.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))})
    })
    @GetMapping
    public ResponseEntity<List<Herois>> getHerois() {
        return ResponseEntity.status(HttpStatus.OK).body(heroiService.buscarTodosHerois());
    }

    @Operation(summary = "Atualizar Herói")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "O heroi foi atualizado com sucesso", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Herois.class))}),
            @ApiResponse(responseCode = "409", description = "Já existe um herói com esse nome cadastrado", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))}),
            @ApiResponse(responseCode = "404", description = "Não existe um herói cadastrado com esse Id", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))}),
            @ApiResponse(responseCode = "400", description = "ID inválido", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))})
    })
    @PutMapping("/{id}")
    public ResponseEntity<Herois> putHeroi(@RequestBody @Valid HeroiRecord heroiDto, @PathVariable Long id) {
        Herois heroi = heroiService.buscarPorId(id);
        List<Superpoderes> superpoderes = superpoderService.buscarSuperpoderes(heroiDto.superpoderIds());

        heroi.setNomeHeroi(heroiDto.nomeHeroi());
        heroi.setNome(heroiDto.nome());
        heroi.setAltura(heroiDto.altura());
        heroi.setPeso(heroiDto.peso());
        heroi.setDataNascimento(heroiDto.dataNascimento());
        heroi.setSuperpoderes(superpoderes);

        return ResponseEntity.status(HttpStatus.CREATED).body(heroiService.salvar(heroi));
    }

    @Operation(summary = "Deletar Heroi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "O heroi foi deletado com sucesso", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Herois.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))}),
            @ApiResponse(responseCode = "404", description = "Não existe um herói cadastrado com esse Id", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))}),
            @ApiResponse(responseCode = "400", description = "ID inválido", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionMessage.class))})
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteDenuncia(@PathVariable Long id) {
        heroiService.apagarHeroi(id);
    }
}
