package com.raxy.clinica.Data;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// interface que usa o nosso model e cria uma api tipo rest
@RepositoryRestResource(collectionResourceRel = "agendamentos", path = "agendamentos")//cria uma api rest
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    @Query("SELECT a FROM Agendamento a WHERE a.nomePaciente = ?1")
    List<Agendamento> findByNomePaciente(String nomePaciente);

    @Query("SELECT a FROM Agendamento a WHERE a.nomeMedico = ?1")
    List<Agendamento> findByNomeMedico(String nomeMedico);

    @Query("SELECT a FROM Agendamento a WHERE a.consultaFeita = ?1 ")
    List<Agendamento> findByConsultaFeita(Boolean consultaFeita);

}

