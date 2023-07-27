<template>
  <div class="center">
    <div>
      <h2>Consultas Feitas</h2>

      <ul class="card">
        <li v-for="agendamento in agendamentos" :key="agendamento.dataHora">
          <h3 class="card-header">Consulta Feita: {{ agendamento.consultaFeita ? 'Sim' : 'Não' }}</h3>
          <div class="card-body">
            <h5>Nome do Paciente: {{ agendamento.nomePaciente }}</h5>
            <h5>Nome do Médico: {{ agendamento.nomeMedico }}</h5>
            <h5>Nome da Consulta: {{ agendamento.nomeConsulta }}</h5>
            <h5>Data e Hora: {{ agendamento.dataHora }}</h5>
            <button class="btn btn-danger" @click="deletarAgendamento(agendamento)">Deletar</button>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>


<style>
li {
  list-style: none;
}
</style>

<script>
export default {
  data() {
    return {
      agendamentos: [] // Inicializar como uma lista vazia
    };
  },
  methods: {
    carregarAgendamentosFeitos() {
      const url = "http://127.0.0.1:8080/agendamentos/feitos";

      fetch(url)
        .then(response => {
          if (response.ok) {
            return response.json();
          } else {
            throw new Error("Erro na requisição.");
          }
        })
        .then(data => {
          // Transformar o objeto recebido em uma lista de um elemento
          this.agendamentos = Object.values(data);
          console.log(this.agendamentos);
        })
        .catch(error => {
          console.error("Erro:", error);
        });
    },

    // Restante do código do componente...
  },
  mounted() {
    this.carregarAgendamentosFeitos();
  }
};
</script>
