FROM openjdk:8
COPY ./target/diciplina-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/src/diciplina/
WORKDIR /usr/src/diciplina
EXPOSE 8080
CMD ["java", "-jar", "diciplina-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]