# 1. Estágio de Compilação
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copia apenas o pom.xml e o código fonte (evita copiar pastas pesadas locais)
COPY pom.xml .
COPY src ./src

# Compila o projeto gerando o .jar sem rodar os testes
RUN mvn clean package -DskipTests

# 2. Estágio de Execução
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia o .jar compilado no estágio anterior
COPY --from=build /app/target/*.jar app.jar

# Configuração da JVM para rodar leve no Render (256MB max heap)
ENV JAVA_TOOL_OPTIONS="-Xms128m -Xmx256m -XX:+UseSerialGC"

# Porta padrão do Render
EXPOSE 10000

# Executa a aplicação mapeando a porta dinamicamente ou usando a 10000
ENTRYPOINT ["java", "-jar", "app.jar"]