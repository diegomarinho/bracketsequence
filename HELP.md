# Getting Started

## Tecnologias
- Java 17
- Maven (3.6.3 ou posterior)
- Spring Boot 3.1.4
- Base de dados PostgreSQL
- Lombok - Biblioteca focada em produtividade e redução de código boilerplate
- Swagger
- Render

## Funcionalidade
API REST que valide se uma sequência de colchetes é balanceada. A
entrada será uma string de colchetes e sua função deve determinar se a ordem dos
colchetes é válida, considerando as seguintes condições:

Não contém colchetes sem correspondência.
O subconjunto de colchetes dentro dos limites de um par de colchetes correspondente
também é um par de colchetes correspondente.
Exemplos:
"(){}[]" é válido
"{()}{}" é válido
"[]{()" não é válido
"[{)]" não é válido

## Inicialização
```sh
mvn spring-boot:run
```

## PostgreSQL external Database
```sh
URL: jdbc:postgresql://dpg-clnpkcofvntc73b5s1t0-a.oregon-postgres.render.com/testdb_01a3
username=sa
password=
```

## Testes
Foram implementados testes unitários e integrados, para execução dos testes:
```sh
mvn test
```

## Swagger
```sh
https://bracketsequence.onrender.com/bracketsequence/swagger-ui/index.html
```