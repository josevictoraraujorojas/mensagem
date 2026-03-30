# 📡 Sistema de Mensagens Distribuído com Quarkus (HTTP)

## 📌 1. Descrição

Este projeto tem como objetivo implementar uma aplicação distribuída simples utilizando o framework Quarkus, explorando o protocolo HTTP como mecanismo de comunicação entre processos.

A aplicação simula um sistema de envio e recebimento de mensagens, permitindo operações de criação, consulta e remoção de mensagens através de uma API REST.

---

## 🧱 4.1 Arquitetura da Solução

A aplicação foi desenvolvida utilizando uma arquitetura em camadas, composta por:

* **Resource (Controller)** → Interface HTTP (entrada e saída de dados)
* **Service** → Lógica de negócio
* **Repository** → Armazenamento em memória
* **Model (Mensagem)** → Representação completa da entidade
* **DTO (MensagemDTO)** → Objeto utilizado para entrada de dados

---

### 🔁 Fluxo de uma requisição `POST /mensagens`

1. O cliente (Postman) envia uma requisição HTTP do tipo POST.
2. O corpo da requisição contém um JSON com os dados da mensagem.
3. O Quarkus converte automaticamente o JSON em um objeto `MensagemDTO`.
4. O `MensagemResource` recebe o DTO.
5. O Resource chama o `MensagemService`.
6. O Service transforma o DTO em uma entidade `Mensagem`.
7. O `MensagemRepository` armazena a mensagem em uma lista em memória.
8. O sistema gera automaticamente:

  * ID da mensagem
  * Timestamp
9. A resposta é retornada ao cliente com status **201 Created**.

---

### 🧑‍💻 Identificação dos Componentes

* **Sender (Remetente):** Cliente HTTP (Postman)
* **Receiver (Destinatário):** Aplicação Quarkus

---

### 🌐 Papel do Protocolo HTTP

O HTTP atua como meio de comunicação entre os processos distribuídos, sendo responsável por:

* Transportar os dados da requisição
* Definir o tipo de operação (GET, POST, DELETE)
* Encapsular os dados no corpo da requisição no formato JSON
* Operar sobre o protocolo TCP

---

## 🔄 Mapeamento Teórico (Send/Receive)

| Método HTTP | Operação no Sistema | Conceito Teórico               |
| ----------- | ------------------- | ------------------------------ |
| POST        | Criar mensagem      | SEND (envio de dados)          |
| GET         | Buscar mensagens    | RECEIVE (recebimento de dados) |
| DELETE      | Remover mensagem    | Alteração de estado            |

---

## 📊 4.2 Evidências de Funcionamento

### 🔹 Tabela de Testes

| Método | Endpoint        | Descrição              | Status Esperado |
| ------ | --------------- | ---------------------- | --------------- |
| GET    | /mensagens      | Listar todas mensagens | 200 OK          |
| GET    | /mensagens/{id} | Buscar mensagem por ID | 200 / 404       |
| POST   | /mensagens      | Criar nova mensagem    | 201 Created     |
| DELETE | /mensagens/{id} | Remover mensagem       | 200 / 404       |

---

### 📷 Evidências (prints)

> Inserir abaixo os prints do Postman ou logs do terminal demonstrando:

* Requisição GET funcionando
* Requisição POST com criação de mensagem
* Requisição GET por ID existente e inexistente
* Requisição DELETE funcionando

---

## 📌 Status Codes Utilizados

### ✅ 200 OK

Utilizado quando a requisição é processada com sucesso:

* Listagem de mensagens (GET)
* Busca por ID existente
* Remoção bem-sucedida

---

### 🆕 201 Created

Utilizado quando uma nova mensagem é criada com sucesso:

* Endpoint POST /mensagens

Indica que o recurso foi criado no servidor.

---

### ❌ 404 Not Found

Utilizado quando o recurso solicitado não é encontrado:

* Buscar mensagem com ID inexistente
* Deletar mensagem inexistente

---

## 🧪 Testes

Os testes foram realizados utilizando o Postman, enviando requisições HTTP para todos os endpoints implementados e validando os códigos de resposta retornados.

---

## 🚀 Tecnologias Utilizadas

* Java
* Quarkus
* RESTEasy Reactive (JAX-RS)
* Jackson (JSON)
* Postman

---

## 📁 Estrutura do Projeto

```
src/main/java/

├── model
│   └── Mensagem.java
│
├── dto
│   └── MensagemDTO.java
│
├── repository
│   └── MensagemRepository.java
│
├── service
│   └── MensagemService.java
│
└── resource
    └── MensagemResource.java
```

---

## ✅ Conclusão

O projeto demonstrou na prática como o protocolo HTTP pode ser utilizado como mecanismo de comunicação em sistemas distribuídos, aplicando o modelo de envio e recebimento de mensagens.

A utilização do Quarkus facilitou a construção da API REST, abstraindo os detalhes de baixo nível da comunicação via TCP e permitindo foco na lógica da aplicação.

O uso de DTO contribuiu para uma melhor organização do sistema, separando os dados de entrada da estrutura interna da aplicação.

---
