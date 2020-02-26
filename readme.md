# Sandbox exercise Project

## How to start
Launch database: docker/database/
docker-compose up -d

Default port: 3306
Database name: eurovisiondb

## System Properties Required
DATABASE_HOST=localhost
DATABASE_PORT=3306
DATABASE_SCHEMA=eurovisiondb
DATABASE_USERNAME=admin
DATABASE_PASSWORD=admin

## Swagger API
Swagger: http://<serverUrl>:<serverPort>/sand-box/swagger-ui.html
Local: http://localhost:8080/sand-box/swagger-ui.html

## How to stop
$docker-compose down