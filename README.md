# redis-om-spring-jph
GitHub based off redis-om-spring blog in redis developer portal

- [redis-om-spring Document tutorial](https://developer.redis.com/develop/java/spring/redis-om/redis-om-spring-json/)

## Outline
- [Overview](#overview)
- [Initial Project Setup](#initial-project-setup)
- [Important Links](#important-linksnotes)
- [Instructions](#instructions)
  - [Create Environment](#create-environment)
  - [Docker Compose](#docker-compose)
  - [Compile, build, run](#compile-build-and-run)
  - [Test API](#test-api)


## Overview

This GitHub completes a small redis-om-spring tutorial showing the annotations for a simplified web interface using
company data.

## Important Links/Notes
* [redis-om-spring Document tutorial](https://developer.redis.com/develop/java/spring/redis-om/redis-om-spring-json/)
* [redis-om-spring on developer.redis.com](https://developer.redis.com/develop/java/spring/redis-om/redis-om-spring/)
* [Redis Stack](https://redis.com/blog/introducing-redis-stack/)
* [Redis Search](https://redis.io/docs/stack/search/)
* [Redis Insight](https://redis.io/docs/stack/insight/)
* [Redis Developer Hub](https://developer.redis.com)
* [Redis LaunchPad](https://launchpad.redis.com)
* [Redis University](https://university.redis.com)

## Instructions

### Create environment
Clone the GitHub
```bash
get clone https://github.com/jphaugla/redis-om-spring-jph.git
```
### Docker Compose

Build just needs to be done initially.  NOTE:  if building a new image for k8s, ensure the Dockerfile is doing a copy of the src directory
into the image and not relying on docker-compose mount of the src directory.  Additionally, docker can be run with the Java application.  See [java readme](java-jedis/README.md)
```bash
docker-compose up -d
```

### Compile, build, and run
Maven is used to compile build and run
```bash
./mvnw clean package
./mvnw spring-boot:run
```

### Test API
Scripts are provided in the scripts directory to verify API functionality
```bash
./getCompany.sh
./geoQuery.sh
./getNoe.sh
./getNoeRange.sh
./startWith.sh
./tagQuery.sh
```


