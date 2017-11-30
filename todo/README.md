# Build

```
mvn clean package
docker build -t dk.jarry/todo .
```

# RUN Container

```
docker rm -f todo || true
docker run -d -p 8080:8080 -p 4848:4848 --name todo dk.jarry/todo
```

# RUN Service

```
docker service rm todo || true
docker service create --name todo --publish 8080 --replicas 1 dk.jarry/todo:latest
docker service update --publish-add 8181 todo

```

# Links

Nice way to watch a Docker engine or Swarm -> [Portainer](https://portainer.io/install.html)
