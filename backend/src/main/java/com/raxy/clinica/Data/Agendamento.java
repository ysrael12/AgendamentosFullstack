
package com.raxy.clinica.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

//model agendamentos

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomePaciente;
    private String nomeMedico;
    private String nomeConsulta;
    private LocalDateTime dataHora;
    private Boolean consultaFeita = false ;


    //getter e setters


    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeConsulta() {
        return nomeConsulta;
    }

    public void setNomeConculta(String nomeConsulta) {
        this.nomeConsulta = nomeConsulta;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public Boolean getConsultaFeita() {
        return consultaFeita;
    }

    public void setConsultaFeita(Boolean consultaFeita) {
        this.consultaFeita = consultaFeita;
    }
}