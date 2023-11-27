FROM maven:3.6.3-jdk-17-slim AS build
WORKDIR /app
COPY . /app/
RUN mvn package -DskipTests


FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]