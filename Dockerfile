# Etapa 1: Construcción de la aplicación con Maven y OpenJDK 11
FROM maven:3.8.6-openjdk-11-slim AS build

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente del proyecto y compilar
COPY src ./src
RUN mvn clean install -DskipTests

# Etapa 2: Ejecutar la aplicación en contenedor con OpenJDK 17
FROM openjdk:11-jdk-slim

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR compilado desde la etapa de construcción
COPY --from=build /app/target/ejercicio_practico-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que Spring Boot estará ejecutándose
EXPOSE 9898

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
