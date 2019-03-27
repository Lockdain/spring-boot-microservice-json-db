FROM tomcat:9.0
COPY /target/gs-handling-form-submission-0.1.0.war /usr/local/tomcat/webapps/myapp.war
