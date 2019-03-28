FROM java:8
EXPOSE 8080
COPY /target/gs-handling-form-submission-0.1.0.jar gs-handling-form-submission-0.1.0.jar
ENTRYPOINT ["java", "-jar", "gs-handling-form-submission-0.1.0.jar"]
