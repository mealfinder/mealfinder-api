Running PostgreSQL in DEV Environment with Docker
```shell
docker run --name mealfinder -d -p 5432:5432 -e POSTGRES_USER=rickybustillos -e POSTGRES_PASSWORD=superpassword -e POSTGRES_DB=mealfinder postgres
```