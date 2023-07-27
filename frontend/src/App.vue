<script setup lang="ts">
import Mainpage from './components/ListaAgendamento.vue';

import { ref, computed } from 'vue';
import PostAgendamento from './components/PostAgendamento.vue';
import Pesquisa from './components/Pesquisa.vue';
import ListaAgendamentoFeitos from './components/ListaAgendamentosFeitos.vue';
import ListaAgendamentoPendentes from './components/ListaAgendamentosPendentes.vue'
import PesquisaMedicos from './components/PesquisaMedicos.vue'


const currentPath = ref(window.location.hash);


const routes = {
  '/': Mainpage,
  '/post': PostAgendamento,
  '/pesquisa': Pesquisa,
  '/feitos' : ListaAgendamentoFeitos,
  '/pendentes': ListaAgendamentoPendentes,
  '/pesquisa-medicos': PesquisaMedicos

}

window.addEventListener('hashchange', () => {
  currentPath.value = window.location.hash
})

const currentView = computed(() => {
  return routes[currentPath.value.slice(1) || '/'] || NotFound
})
</script>

<template>
      <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <a class="navbar-brand" href="#/">Agendamentos</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#/post">Criar Agendamentos</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page"  href="#/pesquisa">Pesquisar agendamento</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="#/feitos">Consultas feitas</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="#/pendentes">Consultas pendentes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="#/pesquisa-medicos">Pesquisar medicos</a>
              </li>

            </ul>
          </div>
        </div>
      </nav>
    <component :is="currentView" />
 
</template>

<style scoped>

</style>

