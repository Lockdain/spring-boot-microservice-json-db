Перед сборкой проекта необходимо настроить Maven Wrapper и добавить в pom.xml dockerfile-maven-plugin:
    1. Перейти в корневую папку проекта
    2. mvn -N io.takari:maven:0.7.5:wrapper
    3. В папке появятся скрипты wrapper'а

Для сборки docker-image:
    1. В корневой папке проекта выполнить ./mvnw install dockerfile:build
    Предварительно проверить Dockerfile в корневой папке проекта

Для запуска docker-container:
    1. Проверить, что контейнер работает docker ps
    2. Выполнить docker run -p 8080:8080 -t springio/gs-spring-boot-docker, где последнее - имя в тэге repository pom.xml.

Остановка запущенного контейнера docker stop
Доступ в bash внутренней системы, запущенной в контейнере docker exec -it d78d66480243 bash

Для локального тестирования приложения добавить в pom.xml зависимость spring-boot-maven-plugin, перед сборкой docker-image снова убрать.
Для локального тестирования убрать packaging из pom.xml.
Убрать SpringBootServletInitializer из класса application.SpringBootApplication.

Ветка для разворачивания проекта во внутреннем контейнере Spring Boot.