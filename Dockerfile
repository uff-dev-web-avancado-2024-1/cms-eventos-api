# Usar a imagem oficial do OpenJDK como imagem base
FROM openjdk:22-jdk

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo pom.xml e o diretório src para o contêiner
COPY . .

# Executar o Maven para construir o projeto e criar o JAR
RUN ./mvnw clean package -DskipTests

# Definir a porta que a aplicação irá utilizar
EXPOSE 8080

# Comando para executar a aplicação Spring Boot
CMD ["java", "-jar", "target/cms-eventos-api-0.0.1-SNAPSHOT.jar"]
