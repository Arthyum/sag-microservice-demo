#!/usr/bin/env bash

#docker stack deploy --compose-file docker-compose-swarm.yml sagmicroservicedemo
docker stack deploy --compose-file=<(docker-compose --file docker-compose-swarm.yml config) sagmicroservicedemo