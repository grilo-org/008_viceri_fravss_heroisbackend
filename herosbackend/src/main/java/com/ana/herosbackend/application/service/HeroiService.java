package com.ana.herosbackend.application.service;

import com.ana.herosbackend.api.ExceptionHandler.Exceptions.HeroiDuplicadoException;

import com.ana.herosbackend.api.ExceptionHandler.Exceptions.HeroiNaoEncontradoException;

import com.ana.herosbackend.api.ExceptionHandler.Exceptions.NenhumHeroiEncontradoException;
import com.ana.herosbackend.api.ExceptionHandler.Exceptions.TamanhoCampoInvalidoException;
import com.ana.herosbackend.domain.model.Herois;
import com.ana.herosbackend.domain.repository.HeroiRepository;
import jakarta.transaction.Transactional;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import java.sql.DataTruncation;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class HeroiService {

    @Autowired
    private HeroiRepository heroiRepository;

    @Transactional
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
                if(ex.getRootCause() instanceof SQLIntegrityConstraintViolationException) {
                    throw new HeroiDuplicadoException("Já existe um herói com esse nomeHeroi.");
                } else if(ex.getRootCause() instanceof DataTruncation){
                     throw new TamanhoCampoInvalidoException("O valor inserido é grande demais.");
                }
        }
    return null;
    }

    public List<Herois> buscarTodosHerois() {
        List<Herois> herois = heroiRepository.findAll();

        if (herois.isEmpty()) {
            throw new NenhumHeroiEncontradoException("Não existem heróis cadastrados.");
        }

        return herois;
    }

    @Transactional
    public void apagarHeroi(Long id) {
        Herois heroi = heroiRepository.findById(id)
                .orElseThrow(HeroiNaoEncontradoException::new);
        heroiRepository.delete(heroi);
    }
}
