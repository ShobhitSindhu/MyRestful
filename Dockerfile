FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/MyRestfulService-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java","-jar","app.war"]