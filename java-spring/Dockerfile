# using openjdk:17-slim only because this is java LTS and available as amd64 and arm64 build to run on my local M1Pro based dev engine
FROM openjdk:17-slim AS builder

RUN mkdir -p /app
WORKDIR /app
COPY . .
RUN ./mvnw clean package spring-boot:repackage

FROM openjdk:17-slim AS RUNTIME

RUN mkdir /app && \
    chown -R 1001:1001 /app
USER 1001
COPY --from=builder --chown=1001:1001 /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT java -jar /app/app.jar
