package com.ana.herosbackend.application.service;

import com.ana.herosbackend.domain.model.Herois;
import com.ana.herosbackend.domain.repository.HeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroiService {

    @Autowired
    private HeroiRepository heroiRepository;

    public Herois buscarPorId(Long id) {
        return heroiRepository.findById(id).isPresent() ? heroiRepository.findById(id).get() : null;
    }
}
