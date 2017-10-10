FROM openjdk:8-jdk-alpine
ADD build/libs/spring5-kotlin-mongodb-crud-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT exec java -Dspring.profiles.active=$ENVIRONMENT -Djava.security.egd=file:/dev/./urandom -jar /app.jar