package com.ana.herosbackend.domain.repository;

import com.ana.herosbackend.domain.model.Herois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroiRepository extends JpaRepository<Herois, Long> {
}
