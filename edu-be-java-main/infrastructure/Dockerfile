FROM gradle:8.14-jdk21 AS builder

WORKDIR /app

COPY build.gradle settings.gradle /app/
COPY . /app/

RUN gradle :build -x test

#####

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]