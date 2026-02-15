FROM eclipse-temurin:25-jdk-noble AS build
WORKDIR /app

# 1. Copy only the files needed to download dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw

# 2. Download dependencies (this layer is cached)
RUN ./mvnw dependency:go-offline

# 3. Now copy the source code and build
COPY src ./src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:25-jre-noble
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]