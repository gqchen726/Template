# syntax=docker/dockerfile:1

FROM openjdk:8

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
#声明需要暴露的端口
EXPOSE  8080
CMD ["./mvnw", "spring-boot:run"]