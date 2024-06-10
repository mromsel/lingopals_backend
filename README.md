# lingopals_backend

## Installation

- #### Download source from "main" branch

- #### Create application-local.properties

You need to create the credentials file in folder "./lingopals_backend/src/main/resources" with the following credentials:

```
# datasource.url
DB_DATABASE=jdbc:mysql://{DB_HOST_IP}:{DB_HOST_PORT}/{DB_NAME}
# datasource.username
DB_USER={DB_USERNAME}
# datasource.password
DB_PASSWORD={DB_PASSWORD}

# JWT secret key
JWT_SECRET_KEY={SECRET_KEY}
```

## How to deploy in docker (local)

1. Build backend image:
```
docker build -t lingopals_backend:latest .
```
2. Start the docker compose with backend, mysqlbd, phpmyadmin and libretranslate api
```
docker compose up --build
```
## How to deploy just backend

Make sure the credentials in application-local.properties are correct.

1. Build backend image:
```
docker build -t lingopals_backend:latest .
```

2. Run docker container with backend:

```
sudo docker run -d --name lingopals_backend -p 8080:8080 lingopals_backend
```

3. To check if everything is running (shows docker console):
```
sudo docker logs lingopals_backend
```
