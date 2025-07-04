package com.ana.herosbackend.application.service;

import com.ana.herosbackend.api.ExceptionHandler.Exceptions.HeroiDuplicadoException;

import com.ana.herosbackend.api.ExceptionHandler.Exceptions.HeroiNaoEncontradoException;
import com.ana.herosbackend.api.ExceptionHandler.Exceptions.IDInvalidoException;
import com.ana.herosbackend.api.ExceptionHandler.Exceptions.NenhumHeroiEncontradoException;
import com.ana.herosbackend.domain.model.Herois;
import com.ana.herosbackend.domain.repository.HeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import java.util.List;

@Service
public class HeroiService {

    @Autowired
    private HeroiRepository heroiRepository;

    public Herois buscarPorId(Long id) {
            Herois heroi = heroiRepository.findById(id).isPresent() ? heroiRepository.findById(id).get() : null;
            if(heroi == null){
                throw new HeroiNaoEncontradoException();
            }
            return heroi;

    }

    public Herois salvar(Herois heroi) {
        try {
            return heroiRepository.save(heroi);
        } catch (DataIntegrityViolationException ex) {
                throw new HeroiDuplicadoException("Já existe um herói com esse nomeHeroi.");
        }
    }

    public List<Herois> buscarTodosHerois() {
        List<Herois> herois = heroiRepository.findAll();

        if (herois.isEmpty()) {
            throw new NenhumHeroiEncontradoException("Não existem heróis cadastrados.");
        }

        return herois;
    }
}
