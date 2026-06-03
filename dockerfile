# =========================================================
# DOCKERFILE - ECLIPSE SENTINEL
# FELIPE AUGUSTO LOPES FERREIRA RM563982
# KAIQUE MASCARENHAS DOS SANTOS RM565802
# =========================================================
 
# ETAPA 1 - BUILD
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
 
# ETAPA 2 - EXECUCAO
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
 
# USUARIO NAO PRIVILEGIADO
RUN addgroup -S sentinel && adduser -S sentinel -G sentinel
USER sentinel
 
COPY --from=build /app/target/eclipse-sentinel-0.0.1-SNAPSHOT.jar app.jar
 
EXPOSE 8080
 
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "app.jar"]
 