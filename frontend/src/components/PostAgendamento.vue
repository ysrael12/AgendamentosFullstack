<style>
 .center{
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 3rem;

}


#form {
  text-align: center;
  border-radius: 20px;
  width: 50rem;
  background: rgb(221, 237, 238);
  padding: 10px;
}


</style>

<template>
  <div class="center">
    <div clas="mb-3"  id="form">
      <form @submit.prevent="enviarFormulario">
        <label class="text-bg-dark p-3" for="nomePaciente">Nome do Paciente:</label>
        <input class="form-control" type="text" id="nomePaciente" v-model="nomePaciente" required>
        <br>
  
        <label class="text-bg-dark p-3" for="nomeMedico">Nome do Médico:</label>
        <input class="form-control" type="text" id="nomeMedico" v-model="nomeMedico" required>
        <br>
  
        <label class="text-bg-dark p-3" for="nomeConsulta">Nome da Consulta:</label>
        <input class="form-control" type="text" id="nomeConsulta" v-model="nomeConsulta" required>
        <br>
  
        <label class="text-bg-dark p-3" for="dataHora">Data e Hora:</label>
        <input class="form-control" type="datetime-local" id="dataHora" v-model="dataHora" required>
        <br>
  
        <button class="btn btn-dark" id="botao" type="submit">Enviar</button>
      </form>
    </div>
  </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        nomePaciente: "",
        nomeMedico: "",
        nomeConsulta: "",
        dataHora: ""
      };
    },
    methods: {
      enviarFormulario() {
        const body = {
          nomePaciente: this.nomePaciente,
          nomeMedico: this.nomeMedico,
          nomeConsulta: this.nomeConsulta,
          dataHora: this.dataHora
        };
  
        fetch('http://127.0.0.1:8080/agendamentos', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(body)
        })
          .then(response => {
            if (response.ok) {
              // A requisição foi bem-sucedida
              console.log('POST enviado com sucesso!');
              alert("consulta criada com sucesso")
            } else {
              // Ocorreu um erro na requisição
              console.log('Erro ao enviar POST.');
            }
          })
          .catch(error => {
            // Ocorreu um erro ao realizar a requisição
            console.log('Erro de conexão:', error);
          });
      }
    }
  };
  </script>
  