# GraphQL Forum API

Este proyecto sirve funcionales API hacia el cliente web de la aplicación.

---

## Referencias

### Guías

Para ejemplos de como implementar un servidor GraphQL, puede referirse a los siguientes enlaces:

- [GraphQL Service with Spring](https://spring.io/guides/gs/graphql-server)

---

## Requisitos

Se recomienda instalar las siguientes dependencias en su sistema operativo:

* [OpenJDK 21](https://jdk.java.net/archive/)

---

## Iniciar servidor

Para iniciar el servidor GraphQL debe posicionarse sobre la carpeta en la que está el archivo _**pom.xml**_ y
ejecutar el siguiente comando:

```bash
./mvnw clean spring-boot:run
```

### H2 Database

Este proyecto trabaja con la base de datos relacional H2.

Puede acceder a la base de datos desde el siguiente enlace: http://localhost:8080/h2-console

Para conectarse a la base de datos debe iniciar sesión con los siguientes datos:

* Driver class: org.h2.Driver
* JDBC URL: jdbc:h2:mem:testdb
* User Name: sa

### GraphiQL

Este proyecto utiliza GraphiQL como la interfaz web interactiva para explorar y validar los queries y mutaciones
declarados en el esquema de GraphQL.

Puede acceder a GraphiQL desde el siguiente enlace: http://localhost:8080/graphiql