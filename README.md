# shoppe-app project

Thuso's Momentum Active Shoppe Application

## The application's openapi can be retrieved using the below link.

`http://localhost:8080/q/swagger-ui/`

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## The application's metrics can be retrieved using the below link.

`http://localhost:8080/q/metrics/`

