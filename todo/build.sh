#!/bin/sh
mvn clean package && sudo docker build -t dk.jarry/todo .
sudo docker rm -f todo || true
