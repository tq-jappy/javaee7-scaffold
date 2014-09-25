javaee7-sandbox
===============

Java EE 7 Sandbox

## Build

```
./gradlew war
```

## Deploy

Copy build/libs/*.war to ${WILDFLY_ROOT}/standalone/deployments

Start server

## Try to access

http://localhost:8080/javaee7-sandbox/api/hello/world
