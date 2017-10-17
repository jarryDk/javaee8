#!/bin/sh
mvn clean package && sudo docker build -t dk.jarry/todo .
sudo docker rm -f todo || true && sudo docker run -d -p 8080:8080 -p 8181:8181 -p 4848:4848 --name todo dk.jarry/todo 
