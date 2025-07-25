# ⚛️ GraphQL Forum Demo

Este proyecto es una demo desarrollada con tecnologías backend y frontend para ilustrar el proceso de
diseño e implementación de APIs con arquitectura GraphQL.

---

## 🧰 Tecnologías

Esta demo está construida con las tecnologías:

### Backend

- Spring Data JPA
- Spring for GraphQL

### Frontend

- Vite + React
- Apollo Client

---

## 📚 Referencias

### Documentación

Para mayor documentación sobre la arquitectura GraphQL, puede referirse a los siguientes enlaces:

- [GraphQL](https://graphql.org/learn/)
- [GraphQL Libraries](https://graphql.org/community/tools-and-libraries/)
- [GraphQL over HTTP](https://graphql.org/learn/serving-over-http/)
- [Apollo GraphQL Naming Conventions](https://www.apollographql.com/docs/graphos/schema-design/guides/naming-conventions)
- [Migrating from REST to GraphQL](https://docs.github.com/en/graphql/guides/migrating-from-rest-to-graphql)

---

## 📝 Proyecto

Eres un desarrollador freelancer y eres contactado por un cliente interesado en contratarte para desarrollar
un foro de discusión pública estilo Reddit, Quora o Stack Overflow.

El cliente indica que este proyecto debe satisfacer los siguientes requisitos funcionales:

- [x] El usuario puede realizar publicaciones.
- [x] El usuario puede realizar comentarios en las publicaciones.
- [x] El usuario puede votar a favor o en contra de las publicaciones.
- [x] El usuario puede votar a favor o en contra de los comentarios.
- [x] Al usuario se le debe presentar un listado con las publicaciones más populares en la página de inicio.

### 💭 Requisitos funcionales

Anotas los requisitos funcionales del cliente, pero da la sensación de que están muy abiertos a la
interpretación o son muy vagos, por lo que le haces las siguientes preguntas para salir de dudas:

1. ¿Cualquier persona puede publicar o ver publicaciones y/o comentarios?
2. ¿Qué tipo de datos puede contener una publicación? (texto, imágenes, videos, etc)
3. ¿Cuál es el significado de la frase "las publicaciones más populares"?

El cliente contesta a tus preguntas con lo siguiente:

* El usuario debe registrarse e iniciar sesión para publicar, comentar y votar.
* El usuario debe tener la capacidad de crear una publicación que contenga:
  * Título.
  * Etiquetas.
  * Cuerpo (texto).
* El usuario debe tener la capacidad de comentar sobre cualquier publicación existente.
* Los comentarios deben estar ordenados por popularidad.
* El usuario puede votar a favor o en contra de una publicación o comentario ya existente.
* La popularidad se define como la cantidad de votos positivos menos la cantidad de votos negativos.

¡Ahora que los requisitos funcionales del proyecto están más claros, ya podemos analizar la solución! 🔥