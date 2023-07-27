

# Documentação da API Clínica

## Introdução

Esta é a documentação da API de Clínica, desenvolvida com o framework Spring Boot em Java. A API permite a gestão de agendamentos médicos, fornecendo endpoints para criar, listar e pesquisar agendamentos com base em diferentes critérios, como nome de paciente, nome de médico e status de consulta.

## Pacote com.raxy.clinica.Data

### Classe Agendamento

A classe `Agendamento` é uma entidade mapeada que representa os agendamentos no sistema. Ela é anotada com `@Entity`, indicando que os objetos dessa classe são mapeados para registros na tabela de agendamentos do banco de dados.

#### Atributos

- `id` (long): Identificador único do agendamento (gerado automaticamente).
- `nomePaciente` (String): Nome do paciente agendado.
- `nomeMedico` (String): Nome do médico responsável pelo agendamento.
- `nomeConsulta` (String): Nome da consulta agendada.
- `dataHora` (LocalDateTime): Data e hora do agendamento.
- `consultaFeita` (Boolean): Indica se a consulta foi realizada (true) ou não (false).

#### Getter e Setter

A classe possui os métodos getter e setter para cada atributo, permitindo acessar e modificar seus valores.

## Pacote com.raxy.clinica.Controllers

### Classe AgendamentoFeitoEPendentesController

A classe `AgendamentoFeitoEPendentesController` é um controlador que lida com as requisições de filtragem de agendamentos feitos e pendentes. Ela utiliza o repositório `AgendamentoRepository` para buscar os agendamentos com base no status de consulta (feita ou não feita).

#### Rotas

- **GET /agendamentos/feitos**: Retorna a lista de agendamentos feitos (consultaFeita = true).

  - **Resposta**:
    - Lista de agendamentos feitos (com consultaFeita = true).

- **GET /agendamentos/pendentes**: Retorna a lista de agendamentos pendentes (consultaFeita = false).

  - **Resposta**:
    - Lista de agendamentos pendentes (com consultaFeita = false).

### Classe PesquisaPorMedicoController

A classe `PesquisaPorMedicoController` é um controlador que lida com as requisições de pesquisa de agendamentos por nome de médico. Ela utiliza o repositório `AgendamentoRepository` para buscar os agendamentos correspondentes ao nome do médico pesquisado.

#### Rotas

- **GET /agendamentos/pesquisa-medico**: Retorna a lista de agendamentos com base no nome do médico.

  - **Parâmetros**:
    - `nomeMedico` (string): Nome do médico para a pesquisa.

  - **Resposta**:
    - Lista de agendamentos correspondentes ao nome do médico fornecido.

### Classe AgendamentoRepository

A interface `AgendamentoRepository` é responsável por fornecer métodos para acessar os dados dos agendamentos e criar uma API RESTful automaticamente para interagir com esses dados.

#### Rotas

- **GET /agendamentos**: Lista todos os agendamentos.

  - **Resposta**:
    - Lista de todos os agendamentos registrados.

- **GET /agendamentos/search/findByNomePaciente?nomePaciente={nomePaciente}**: Busca agendamentos pelo nome do paciente.

  - **Parâmetros**:
    - `nomePaciente` (string): Nome do paciente para a busca.

  - **Resposta**:
    - Lista de agendamentos correspondentes ao nome do paciente fornecido.

- **GET /agendamentos/search/findByNomeMedico?nomeMedico={nomeMedico}**: Busca agendamentos pelo nome do médico.

  - **Parâmetros**:
    - `nomeMedico` (string): Nome do médico para a busca.

  - **Resposta**:
    - Lista de agendamentos correspondentes ao nome do médico fornecido.

- **GET /agendamentos/search/findByConsultaFeita?consultaFeita={consultaFeita}**: Busca agendamentos pelo status de consulta (feita ou não feita).

  - **Parâmetros**:
    - `consultaFeita` (boolean): Valor booleano indicando se a consulta foi feita (True) ou não (False).

  - **Resposta**:
    - Lista de agendamentos correspondentes ao status de consulta fornecido.

#### Rota de Criação de Agendamento

- **POST /agendamentos**: Cria um novo agendamento.

  - **Corpo da Requisição**:
    - `nomePaciente` (string): Nome do paciente para o agendamento.
    - `nomeMedico` (string): Nome do médico responsável pelo agendamento.
    - `nomeConsulta` (string): Nome da consulta agendada.
    - `dataHora` (LocalDateTime): Data e hora do agendamento.
    - `consultaFeita` (boolean): Indicador se a consulta já foi realizada (true) ou não (false).

  - **Resposta**:
    - Informações detalhadas do agendamento criado.

## Considerações Finais

Essa documentação detalhou a API de Clínica, incluindo as classes `Agendamento` e `AgendamentoRepository`, bem como os controladores `AgendamentoFeitoEPendentesController` e `PesquisaPorMedicoController`. A API oferece recursos para criar, listar e pesquisar agendamentos com base em diferentes critérios, facilitando a gestão de agendamentos em uma clínica médica. O

 código aqui apresentado é apenas uma parte do projeto completo da API Clínica e pode ser integrado a outras partes do sistema para fornecer um serviço completo e funcional.
