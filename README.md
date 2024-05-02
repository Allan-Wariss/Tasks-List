# Task List API

## Descrição
Projeto Task List Manager desenvolvido como desafio da Diel. O aplicativo consiste em um gerenciador de tarefas, com funcionalidades para listar todas as tarefas, obter detalhes de uma tarefa específica, criar, atualizar, pesquisar pelo título e excluir tarefas.

## Tecnologias Utilizadas
- [Spring Boot](https://spring.io/projects/spring-boot) - Framework para a criação de aplicativos Java.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Facilita a interação com bancos de dados relacionais.
- [Spring Web](https://spring.io/guides/gs/spring-boot/) - Facilita o desenvolvimento de aplicativos web com Spring.
- [PostgreSQL/J](https://jdbc.postgresql.org) - Conector JDBC para PostgrSQL.
- [Lombok](https://projectlombok.org/) - Biblioteca para reduzir a verbosidade do código.

## Pré-requisitos
- Java 17.0.7
- Maven
- PostgreSql

## Configuração do Banco de Dados
- Os dados já estão configurados, mas caso deseje mudar siga as orietações
- Configure as propriedades do banco de dados no arquivo `application.properties` com as informações do seu banco PostgreSql.

```properties
spring.datasource.url=jdbc:postgresql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Use em nuvem
- Este Back-End está hospedado no railway
-Link da API: https://tasks-list-production.up.railway.app/tasks/

## Executando o Projeto Localmente
1. Clone o repositório.
2. Configure o banco de dados conforme descrito acima.
3. Execute a aplicação usando uma IDE.
4. O aplicativo estará disponível em [http://localhost:8080](http://localhost:8080).

## Endpoints

- **GET /tasks/findAll** Retorna todas as tarefas.
- **GET /tasks/find/{title}:** Retorna os detalhes de uma tarefa específica pelo titulo.
- **POST /tasks/add:** Cria uma nova tarefa.
- **PUT /tasks/edit/{taskId}:** Atualiza os detalhes de uma tarefa existente.
- **DELETE /tasks/delete/{taskId}:** Exclui uma tarefa.
