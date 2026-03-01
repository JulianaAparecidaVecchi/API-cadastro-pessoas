# People Management API

API REST desenvolvida com Spring Boot para gerenciamento de Pessoas.

---

## 📌 Sobre o projeto

Este projeto é uma API REST que permite:

- Criar pessoas
- Listar pessoas
- Atualizar pessoas
- Deletar pessoas
- Criar jogos
- Listar jogos
- Atualizar jogos
- Deletar jogos

Projeto desenvolvido com foco em prática de arquitetura REST e boas práticas com Spring Boot.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 3.4.3
- Spring Data JPA
- Banco de Dados H2
- Swagger (OpenAPI)
- Maven

---

## ⚙️ Como executar o projeto

Clone o repositório:

```bash
git clone https://github.com/JulianaAparecidaVecchi/people-management-api.git
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

## 📚 Documentação da API

Swagger disponível em:

```
http://localhost:8080/swagger-ui.html
```

---

## 📌 Endpoints principais

### 👤 Pessoas

| Método | Endpoint              | Descrição |
|--------|----------------------|-----------|
| POST   | /person/add          | Criar pessoa |
| GET    | /person/list         | Listar todas |
| GET    | /person/list/{id}    | Buscar por ID |
| PUT    | /person/update/{id}  | Atualizar |
| DELETE | /person/delete/{id}  | Deletar |

### 🎮 Jogos

| Método | Endpoint             | Descrição |
|--------|---------------------|-----------|
| POST   | /game/add           | Criar jogo |
| GET    | /game/list          | Listar todos |
| GET    | /game/list/{id}     | Buscar por ID |
| PUT    | /game/update/{id}   | Atualizar |
| DELETE | /game/delete/{id}   | Deletar |

