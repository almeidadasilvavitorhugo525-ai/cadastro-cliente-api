# cadastro-cliente-api

API REST em Spring Boot para cadastro de cliente — atividade da disciplina Estrutura e Classificação de Dados II.

## Entidade Cliente

| Campo    | Tipo   |
|----------|--------|
| id       | Long   |
| nome     | String |
| email    | String |
| telefone | String |

## Endpoints

| Método | Rota           | Descrição                  |
|--------|----------------|------------------------------|
| GET    | /clientes      | Lista todos os clientes      |
| GET    | /clientes/{id} | Busca um cliente por id      |
| POST   | /clientes      | Cadastra um novo cliente     |
| PUT    | /clientes/{id} | Atualiza um cliente          |
| DELETE | /clientes/{id} | Remove um cliente            |

## Como executar

```bash
mvn spring-boot:run
```

A aplicação sobe em `http://localhost:8080`. O console do H2 fica disponível em `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:clientesdb`).

## Stack

- Java 21
- Spring Boot 3.3.4 (Web, Data JPA, Validation)
- H2 Database (em memória)
- Maven
