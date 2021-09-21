<p align="center">
	<img src="https://raw.githubusercontent.com/mealfinder/mealfinder-api/master/assets/mealfinder-api.png" height="200" alt="MealFinder Logotype" />
</p>
<br>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=flat-square&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=flat-square&logo=spring&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=flat-square&logo=intellij-idea&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=flat-square&logo=Apache%20Maven&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=flat-square&logo=postman&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=flat-square&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=flat-square&logo=docker&logoColor=white)

#  Mealfinder API

The MealFinder is an application for you that want to discover new meals.

## Development server

### Configure PostgreSQL Database with Docker

 1. Creating Docker Container with postgres image, creating database and setting database user
```sh
docker run --name mealfinder -d -p 5432:5432 -e POSTGRES_USER=rickybustillos -e POSTGRES_PASSWORD=superpassword -e POSTGRES_DB=mealfinder postgres
```

2. Creating table
```sh
docker run -it --rm --net=host -v %cd%/database:/tmp postgres /bin/bash

psql -h localhost -U rickybustillos mealfinder -f /tmp/tb_meals.sql
```

3. Access
```sh
docker exec -it mealfinder /bin/bash

psql -U rickybustillos mealfinder
```

### Spring Boot

- Java 11
- Maven Project
- Jar
- Spring Web
- Spring Data JPA
- Lombok
- PostgreSQL Driver
