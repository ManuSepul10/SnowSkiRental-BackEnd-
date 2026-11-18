# ☕ Snow Ski Rental – Backend

Backend desarrollado para Snow Ski Rental, encargado de gestionar la lógica de negocio, persistencia de datos y comunicación con los servicios del frontend.

El proyecto implementa una API REST utilizando Java y Spring Boot, con conexión a una base de datos MySQL.

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.3
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- JavaMailSender
- Git y GitHub

## ✨ Características

- Arquitectura basada en Spring Boot.
- Desarrollo de endpoints REST.
- Persistencia de datos mediante Spring Data JPA.
- Integración con MySQL.
- Gestión de suscripciones al newsletter.
- Validación de información recibida.
- Envío de correos electrónicos.
- Separación de responsabilidades mediante controladores, servicios y repositorios.

## 🔌 Endpoint principal

### Registrar suscripción

`POST /api/suscripciones`

Permite registrar una dirección de correo electrónico para recibir novedades y promociones de Snow Ski Rental.

## ⚙️ Requisitos

- Java 17 o superior.
- MySQL.
- Maven.

## 🛠️ Configuración

Configurar las variables de entorno necesarias para la conexión a MySQL y el servicio de correo electrónico.

Crear la base de datos:

```sql
CREATE DATABASE snow_ski;
```

## ▶️ Ejecutar el proyecto

En Windows:

```bash
mvnw.cmd spring-boot:run
```

También se puede ejecutar desde IntelliJ IDEA.

## 🎯 Objetivo del proyecto

Construir un backend robusto y escalable, aplicando arquitectura por capas, persistencia relacional, validaciones y comunicación entre servicios mediante API REST.

**Desarrollador:** Manuel Sepúlveda
