package com.raxy.clinica.Controllers;

import com.raxy.clinica.Data.Agendamento;
import com.raxy.clinica.Data.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class PesquisaPorMedicoController {
    @Autowired
    AgendamentoRepository agendamentoRepository;

    @GetMapping("/pesquisa-medico")
    public List<Agendamento> getByNomeMedico(@RequestParam("nomeMedico") String nomeMedico){
        return agendamentoRepository.findByNomeMedico(nomeMedico);
    }
}
