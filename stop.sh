#!/usr/bin/env bash

docker stop spring5-kotlin-mongo-api | xargs docker rm
docker-compose stop
