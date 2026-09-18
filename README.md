# Porto FullStack Hospital Exercise

## Project Overview
`Porto-FullStack-HospitalEx` is a Spring Boot REST API for managing hospital consultations domain data, focused on doctors and patients.

The project follows a layered architecture:
- **Routing layer** (`routing/`): REST controllers
- **Service layer** (`service/`): business logic
- **Repository layer** (`repository/`): JPA persistence
- **Model/DTO layer** (`model/`): entities, DTOs, enums
- **Mapper utilities** (`utils/`): entity/DTO mapping

## Tech Stack
- Java 25 (Gradle toolchain)
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- H2 (default local database)
- Springdoc OpenAPI UI
- Docker + Docker Compose (PostgreSQL + app runtime)

## Repository Structure
- `consultas/consultas/` - Spring Boot application module
- `consultas/consultas/src/main/java/dtt/formacao/java/consultas/` - Java source code
- `consultas/consultas/src/main/resources/application.properties` - default app configuration (H2)
- `infratructure/Dockerfile` - container image definition
- `docker-compose.yml` - app + PostgreSQL orchestration
- `Documents/Exercicio.pdf` - exercise statement
- `UMLs/usecasediagram.mmd` - use case diagram

## Domain Scope
Based on the current package structure, the API includes:
- `Doctor` and `Patient` core models
- DTOs (`DoctorDTO`, `PatientDTO`)
- shared person attributes (`Person`)
- reference enums (`DocumentType`, `Gender`, `Specialty`)

## API Endpoints
Controllers are located in:
- `consultas/consultas/src/main/java/dtt/formacao/java/consultas/routing/DoctorController.java`
- `consultas/consultas/src/main/java/dtt/formacao/java/consultas/routing/PatientController.java`

For the exact endpoint list and payload schemas, use OpenAPI at runtime.

## Run Locally (Gradle Wrapper)
From the project root:

```powershell
cd consultas/consultas
.\gradlew.bat bootRun
```

Application default URL:
- `http://localhost:8080`

### Local Database (Default)
The default configuration uses an in-memory H2 database:
- JDBC URL: `jdbc:h2:mem:consultasdb`
- User: `sa`
- Password: _(empty)_
- H2 console: `http://localhost:8080/h2-console`

## API Documentation
Swagger/OpenAPI UI is available when the app is running:
- `http://localhost:8080/swagger-ui/index.html`

## Run with Docker Compose
From the repository root:

```powershell
docker compose up --build
```

`docker-compose.yml` defines:
- `postgres` service on `5432`
- `app` service on `8080`
- datasource environment variables pointing app to PostgreSQL

> Note: the default `application.properties` is currently set to H2. If you want to force PostgreSQL outside Docker env vars, uncomment and adjust the PostgreSQL datasource properties.

## Build and Test
From `consultas/consultas`:

```powershell
./gradlew clean build -x test
./gradlew.bat test
```
## Database Configuration
The application can be configured to use either H2 (default) or PostgreSQL. The configuration is managed through the `application.properties` file and environment variables.

```powershell
psql -U postgres -d consultas
```


## Notes
- The project currently uses `create-drop` for JPA schema lifecycle in local config.
- PostgreSQL dependency exists as a commented option in `build.gradle`.
