# Build
mvn clean package && docker build -t dk.jarry/todo .

# RUN

docker rm -f todo || true && docker run -d -p 8080:8080 -p 4848:4848 --name todo dk.jarry/todo 