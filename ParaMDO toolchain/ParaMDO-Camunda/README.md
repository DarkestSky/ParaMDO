# ParaMDO Camunda

The ParaMDO Camunda is a minimal Camunda 7 runtime environment. It is developed as a Spring Boot integration.

Use Docker to run the ParaMDO Camunda:

```bash
docker compose up -d
```

This will create a container of Redis and a container of ParaMDO Camunda.

To run the ParaMDO Camunda locally, please change the address of Redis in `src/main/java/org/buaa/pomes/camunda/config/RedissonConfig.java`

```Java
config.useSingleServer().setAddress("redis://redis:6379");
```
