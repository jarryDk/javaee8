#!/bin/sh
mvn clean package && sudo docker build -t dk.jarry/todo .
sudo docker service rm todo || true
sudo docker service create --name todo --publish 8080 --replicas 1 dk.jarry/todo:latest
sudo docker service update --publish-add 8181 todo
