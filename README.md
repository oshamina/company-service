# Сервис поиска организаций

## Подготовка к работе с проектом
Для работы с проектом необходимо настроить базу данных PostgreSql.
Параметры подключения к базе данных требуется указать в конфигурационном файле `src/main/resources/application-dev.properties`

Например:
```
spring.datasource.url=jdbc:postgresql://localhost:55000/postgres
spring.datasource.username=postgres
spring.datasource.password=********
```
## Сборка и запуск проекта
```
./mvnw spring-boot:run
```

## REST API web-приложения
Описание веб-сервиса поиска организаций доступно в самом приложении по ссылке формата:
http://host:port/swagger-ui.html

Например: `http://localhost:8080/swagger-ui.html`