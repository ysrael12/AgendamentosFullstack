package com.raxy.clinica.Controllers;
import com.raxy.clinica.Data.Agendamento;
import com.raxy.clinica.Data.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller que filtra os agendamentos feitos e nao feitos e depois exibe
@RestController
@RequestMapping("/agendamentos")
public class AgendamentoFeitoEPendentesController {
    @Autowired
    AgendamentoRepository agendamentoRepository;

    @GetMapping("feitos")
    public List<Agendamento> getAgendamentosFeito(){
        return agendamentoRepository.findByConsultaFeita(true);
    }

    @GetMapping("pendentes")
    public List<Agendamento> getAgendamentosPendentes(){
        return agendamentoRepository.findByConsultaFeita(false);
    }


}
