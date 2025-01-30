# Build
mvn clean package && docker build -t com.ee/Todo .

# RUN

docker rm -f Todo || true && docker run -d -p 8080:8080 -p 4848:4848 --name Todo com.ee/Todo 