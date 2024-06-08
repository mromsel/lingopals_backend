# lingopals_backend

## How to deploy in docker

1. Build backend image:
```
docker build -t lingopals_backend:latest .
```

1. Start the docker compose with backend, mysqlbd, phpmyadmin and libretranslate api
```
docker compose up --build
```