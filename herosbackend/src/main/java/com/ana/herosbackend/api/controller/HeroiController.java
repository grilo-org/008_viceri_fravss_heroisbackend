package com.ana.herosbackend.api.controller;

import com.ana.herosbackend.application.service.HeroiService;
import com.ana.herosbackend.domain.model.Herois;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heroi")
public class HeroiController {

    @Autowired
    private HeroiService heroiService;

    @GetMapping("/{id}")
    public ResponseEntity<Herois> getDenunciaById(@PathVariable Long id) {
        Herois heroi = heroiService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(heroi);
    }
}
