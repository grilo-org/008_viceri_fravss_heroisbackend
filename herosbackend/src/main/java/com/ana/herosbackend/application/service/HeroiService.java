package com.ana.herosbackend.application.service;

import com.ana.herosbackend.api.ExceptionHandler.Exceptions.HeroiDuplicadoException;
import com.ana.herosbackend.domain.model.Herois;
import com.ana.herosbackend.domain.repository.HeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class HeroiService {

    @Autowired
    private HeroiRepository heroiRepository;

    public Herois buscarPorId(Long id) {
        return heroiRepository.findById(id).isPresent() ? heroiRepository.findById(id).get() : null;
    }

    public Herois salvar(Herois heroi) {
        try {
            return heroiRepository.save(heroi);
        } catch (DataIntegrityViolationException ex) {
                throw new HeroiDuplicadoException("Já existe um herói com esse nomeHeroi.");
        }
    }
}
