# 1. Estágio de Compilação
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Estágio de Execução
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# O Hugging Face Spaces exige a porta 7860
EXPOSE 7860

ENTRYPOINT ["java", "-Dserver.port=7860", "-jar", "app.jar"]