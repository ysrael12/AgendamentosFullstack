<template>
    <div class="center">
      <form id="form" @submit.prevent="realizarPesquisa">
        <label  class="form-label" for="nomePaciente">Pesquisar por nome do Paciente:</label>
        <input class="form-control" type="text" id="nomePaciente" v-model="nomePaciente" required>
        <button class="btn btn-primary" type="submit">Pesquisar</button>
      </form>
    </div>

    <div v-if="resultadoPesquisa">
      <h2 class="center">Resultado da Pesquisa</h2>
      <ul class="card ">
        <li v-for="resultado in resultadoPesquisa" :key="resultado.id">
          <h3 class="card-header">Consulta Feita: {{ resultado.consultaFeita ? 'Sim' : 'Não' }}</h3>
          <div class="card-body">
            <h5>Nome do Paciente: {{ resultado.nomePaciente }}</h5>
            <h5>Nome do Médico: {{ resultado.nomeMedico }}</h5>
            <h5>Nome da Consulta: {{ resultado.nomeConsulta }}</h5>
            <h5>Data e Hora: {{ resultado.dataHora }}</h5>
            <button class="btn btn-success" @click="marcarConsultaFeita(resultado)">Marcar como Feita</button>
            <button class="btn btn-danger" @click="deletarresultado(resultado)">Deletar</button>
          </div>  
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        nomePaciente: "",
        resultadoPesquisa: null
      };
    },

 
    methods: {
      realizarPesquisa() {
        const url = `http://127.0.0.1:8080/agendamentos/search/findByNomePaciente?nomePaciente=${encodeURIComponent(this.nomePaciente)}`;
  
        fetch(url)
          .then(response => {
            if (response.ok) {
              return response.json();
            } else {
              throw new Error('Erro na requisição.');
            }
          })
          .then(data => {
            this.resultadoPesquisa = data._embedded ? data._embedded.agendamentos : [];
          })
          .catch(error => {
            console.error('Erro:', error);
            this.resultadoPesquisa = null;
          });
      }
    }
  };
  </script>
  