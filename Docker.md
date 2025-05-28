Image -> Рецепт
Container -> Готовое блюдо
Dockerfile -> Процесс приготовления
Docker Compose -> Комбо
Docker Hub -> Место хранилища заготовок

-------------------------------------------------

Dockerfile->
[
FROM openjdk:17-oracle
MAINTAINER almat
COPY first.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]
]

-------------------------------------------------

Создать image -> docker build -t <image_name> .
Видеть images -> docker images
Удалить image -> docker rmi <image_id>
Удалить image -> docker rmi <image_name>
Создать и сразу запустить контейнер -> docker run --name <container_name> -p 8001:8080 <image_name>
Создать и сразу запустить контейнер за кулисами -> docker run -d --name <container_name> -p 8001:8080 <image_name>
Увидеть запущенные контейнеры -> docker ps
Увидеть все контейнеры -> docker ps -a
Запустить готовый контейнер -> docker start <container_name>
Остановить готовый контейнер -> docker stop <container_name>
Удалить готовый контейнер -> docker rm <container_name>

----------------------------------------------------
Создание docker-compose.yml

services:
my-project-backend-service:
image: 'my-spring-boot-project-iso'
container_name: 'my-spring-boot-project-container'
depends_on:
- my-project-database-service
environment:
- SPRING_DATASOURCE_URL=jdbc:postgresql://my-project-database-service:5432/postgres
- SPRING_DATASOURCE_USERNAME=postgres
- SPRING_DATASOURCE_PASSWORD=postgres
- SPRING_JPA_HIBERNATE_DDL_AUTO=none
- SPRING_JPA_SHOW_SQL=true
ports:
- 8888:8080

      my-project-database-service:
        image: 'postgres'
        container_name: 'my-postgresql-database-container'
        environment:
          - POSTGRES_USER=postgres
          - POSTGRES_PASSWORD=postgres
          - POSTGRES_DB=postgres
        ports:
          - 2345:5432

-----------------------------------------------
Запуск docker-compose.yml -> docker-compose up -d
Создание репозитория совего image -> docker tag <image_name> <account_name>/<image_name>
Пуш репозитория в DockerHub -> docker push <account_name>/<image_name>