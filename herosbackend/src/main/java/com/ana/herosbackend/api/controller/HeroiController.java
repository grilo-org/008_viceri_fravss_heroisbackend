package com.ana.herosbackend.api.controller;

import com.ana.herosbackend.api.dtos.HeroiRecord;
import com.ana.herosbackend.application.service.HeroiService;
import com.ana.herosbackend.application.service.SuperpoderService;
import com.ana.herosbackend.domain.model.Herois;
import com.ana.herosbackend.domain.model.Superpoderes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/heroi")
public class HeroiController {

    @Autowired
    private HeroiService heroiService;

    @Autowired
    private SuperpoderService superpoderService;

    @PostMapping
    public ResponseEntity<Herois> saveDenuncia(@RequestBody @Valid HeroiRecord heroiDto) {
        List<Superpoderes> superpoderesList = superpoderService.buscarSuperpoderes(heroiDto.superpoderIds());
        Herois heroi = new Herois();
        heroi.setSuperpoderes(superpoderesList);
        heroi.setNomeHeroi(heroiDto.nomeHeroi());
        heroi.setNome(heroiDto.nome());
        heroi.setAltura(heroiDto.altura());
        heroi.setPeso(heroiDto.peso());
        heroi.dataNascimento(heroiDto.dataNascimento());

        return ResponseEntity.status(HttpStatus.CREATED).body(heroiService.salvar(heroi));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Herois> getDenunciaById(@PathVariable Long id) {
        Herois heroi = heroiService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(heroi);
    }
}
