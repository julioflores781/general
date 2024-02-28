# Test General 

Esta es una aplicación desarrollada en Java 17 con Spring Boot que proporciona una API para gestionar precios de productos. Una vez iniciado el proyecto La documentación de la API se encuentra disponible en  [Swagger UI](http://localhost:8080/api/swagger-ui/index.html).


## Configuraciones Básicas de Java

- **Versión de Java**: Java 17

## Base de Datos

El proyecto utiliza una base de datos H2 embebida con las siguientes configuraciones:

- **URL**: `jdbc:h2:mem:testdb`
- **Nombre de Usuario**: `inditax`
- **Contraseña**: `inditax1234`
- **Ruta de la Consola H2**: `/h2-console`

## Swagger

El proyecto utiliza Swagger para documentación de API. A continuación se detallan algunas configuraciones relevantes:

- **Ruta de Swagger UI**: `/swagger-ui/index.html`
- **Ruta de la API Docs**: `/api-docs`

## Ejecución del Proyecto
```bash
mvn clean package
mvn spring-boot:run
```
## Ejecución de Test
```bash
mvn test
```
