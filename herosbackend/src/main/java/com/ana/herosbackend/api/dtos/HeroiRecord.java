package com.ana.herosbackend.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;

public record HeroiRecord(Long id, @NotBlank String nome, @NotBlank String nomeHeroi, @NotNull Date dataNascimento, @NotNull float peso, @NotNull float altura, @NotEmpty List<Long> superpoderIds) {
}
