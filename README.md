# GraphQL Forum App

Este proyecto está desarrollado con tecnologías de backend y frontend para ilustrar el uso de APIs
con arquitectura GraphQL.

## Referencias

### Documentación

Para mayor documentación sobre la arquitectura GraphQL, puede referirse a los siguientes enlaces:

- [GraphQL](https://graphql.org/learn/)
- [GraphQL Libraries](https://graphql.org/community/tools-and-libraries/)
- [GraphQL over HTTP](https://graphql.org/learn/serving-over-http/)
- [Spring for GraphQL](https://docs.spring.io/spring-graphql/reference/index.html)
- [Apollo GraphQL Naming Conventions](https://www.apollographql.com/docs/graphos/schema-design/guides/naming-conventions)

### Guías

Para ejemplos de como implementar GraphQL en el lado del cliente y en el lado del servidor, puede referirse a
los siguientes enlaces:

- [GraphQL Client with Apollo](https://www.apollographql.com/docs/react/get-started)
- [GraphQL Service with Spring](https://spring.io/guides/gs/graphql-server)

## Requisitos

El proyecto está dividido en 2 grandes secciones: API y WEB. Cada sección cuenta con sus propios requisitos.

### Servidor GraphQL

Para iniciar el servidor api, se recomienda el uso de una versión reciente de **IntelliJ IDEA Community**, el cual
cuenta con versiones de Java y Maven preinstaladas que son compatibles con el proyecto.

Si no puede descargar, instalar y usar IntelliJ IDEA Community, se recomienda instalar las siguientes dependencias
en su sistema operativo.

* [OpenJDK 21](https://jdk.java.net/archive/)
* [Maven 3](https://downloads.apache.org/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.zip)

Para el OpenJDK, se recomienda instalar un build construido, compilado y distribuido por Adoptium (Temurin).

#### Windows

Para Windows, puede utilizar el gestor de paquetes **winget** a través de la consola de Powershell.

```powershell
winget install --id EclipseAdoptium.Temurin.21.JDK --source winget
java -version
```

```powershell
winget install --id Apache.Maven --source winget
mvn -v
```

#### Linux

Para cualquier distribución de Linux, puede utilizar el gestor de paquetes que aplique: apt, dnf, yum, etc.

```bash
sudo apt update
sudo apt install temurin-21-jdk
```

```bash
sudo apt update
sudo apt install maven
```

#### MacOS

Para MacOS, puede utilizar el gestor de paquetes **homebrew** a través de la terminal.

```bash
brew tap homebrew/cask-versions
brew tap adoptium/adoptium
brew install --cask temurin21
/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin/java -version
```

```bash
brew install maven
mvn -version
```

### Cliente GraphQL

Para iniciar el servidor web, se debe instalar NodeJS. Se recomienda instalar una versión superior o igual a NodeJS 16.

#### Windows

Para Windows, puede utilizar el gestor de paquetes **winget** a través de la consola de Powershell.

```powershell
winget install OpenJS.NodeJS
node -v
npm -v
```

#### Linux

Para cualquier distribución de Linux, puede utilizar el gestor de paquetes que aplique: apt, dnf, yum, etc.

```bash
sudo apt update
sudo apt install nodejs npm
node -v
npm -v
```

#### MacOS

Para MacOS, puede utilizar el gestor de paquetes **homebrew** a través de la terminal.

```bash
brew install node
node -v
npm -v
```

## Iniciar Servidor GraphQL

Para iniciar el servidor GraphQL puede ejecutar el siguiente comando sobre la raíz del proyecto:

```bash
mvn clean spring-boot:run
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

## Iniciar Cliente GraphQL

Para iniciar el servidor web, debe instalar las dependencias internas del proyecto a través de npm.

Debe posicionarse sobre la carpeta en la que está el archivo _**package.json**_ y ejecutar el siguiente comando:

```bash
  npm install
```

Una vez instaladas las dependencias internas del proyecto, ya puede iniciar el servidor web a través
del siguiente comando:

```bash
  npm run dev
```