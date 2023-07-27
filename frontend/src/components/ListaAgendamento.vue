<template>
   <div class="center">
    <div  v-if="agendamentos.length > 0">
      <h2>Consultas</h2>

      <ul class="card">
        <li v-for="agendamento in agendamentos" :key="agendamento._links.self.href">

          <h3 class="card-header">Consulta Feita: {{ agendamento.consultaFeita ? 'Sim' : 'Não' }}</h3>
          <div class="card-body">
            <h5>Nome do Paciente: {{ agendamento.nomePaciente }}</h5>
            <h5>Nome do Médico: {{ agendamento.nomeMedico }}</h5>
            <h5>Nome da Consulta: {{ agendamento.nomeConsulta }}</h5>
            <h5>Data e Hora: {{ agendamento.dataHora }}</h5>
            <button class="btn btn-success" @click="marcarConsultaFeita(agendamento)">Marcar como Feita</button>
            <button class="btn btn-danger" @click="deletarAgendamento(agendamento)">Deletar</button>
          </div>  
        </li>
      </ul>
    </div>
  </div>
</template>

<style>
li{
  list-style: none;
}
</style>


<script>
export default {
  data() {
    return {
      agendamentos: []
    };
  },
  methods: {
    carregarAgendamentos() {
      const url = "http://127.0.0.1:8080/agendamentos";

      fetch(url)
        .then(response => {
          if (response.ok) {
            return response.json();
          } else {
            throw new Error("Erro na requisição.");
          }
        })
        .then(data => {
          this.agendamentos = data._embedded ? data._embedded.agendamentos : [];
          
        })
        .catch(error => {
          console.error("Erro:", error);
        });
    },
    

    

    marcarConsultaFeita(agendamento) {
      const url = agendamento._links.self.href;
      const updatedAgendamento = { ...agendamento, consultaFeita: true };

      fetch(url, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(updatedAgendamento)
      })
        .then(response => {
          if (response.ok) {
            console.log("Consulta marcada como feita!");
            agendamento.consultaFeita = true;
          } else {
            throw new Error("Erro ao atualizar a consulta.");
          }
        })
        .catch(error => {
          console.error("Erro:", error);
        });
    },

    deletarAgendamento(agendamento) {
      const url = agendamento._links.self.href;

      fetch(url, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json"
        }
      })
        .then(response => {
          if (response.ok) {
            console.log("Agendamento deletado com sucesso!");
            this.agendamentos = this.agendamentos.filter(item => item !== agendamento);
          } else {
            throw new Error("Erro ao deletar agendamento.");
          }
        })
        .catch(error => {
          console.error("Erro:", error);
        });
    }
  },
  mounted(){
    this.carregarAgendamentos()
  }
};
</script>
