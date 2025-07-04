package com.ana.herosbackend.application.service;

import com.ana.herosbackend.domain.model.Superpoderes;
import com.ana.herosbackend.domain.repository.SuperpoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperpoderService {
    @Autowired
    SuperpoderRepository superpoderRepository;

    public List<Superpoderes> buscarSuperpoderesPorId(List<Long> ids){
        return superpoderRepository.findAllById(ids);

    }
    public List<Superpoderes> buscarSuperpoderes(){
        return superpoderRepository.findAll();

    }
}
