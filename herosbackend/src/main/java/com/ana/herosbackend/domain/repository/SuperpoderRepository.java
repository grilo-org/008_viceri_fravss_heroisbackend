package com.ana.herosbackend.domain.repository;

import com.ana.herosbackend.domain.model.Superpoderes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperpoderRepository extends JpaRepository<Superpoderes, Long> {
}
