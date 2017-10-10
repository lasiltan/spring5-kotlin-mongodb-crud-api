#!/usr/bin/env bash

echo "Starting docker containers"
docker-compose up -d

echo "building jar"
gradle clean build

echo "build docker image"
docker build -t spring5-kotlin-mongo-api .

echo "Running app in docker"
docker run -d --name spring5-kotlin-mongo-api -e ENVIRONMENT=local -p 45678:8080 spring5-kotlin-mongo-api:latest | xargs docker logs -f

