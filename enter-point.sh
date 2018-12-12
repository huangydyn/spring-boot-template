#!/usr/bin/env bash
set -e

NAME=${NAME:-spring-boot-template}

JAR=$(find . -name ${NAME}*.jar|head -1)

java -jar -Dspring.profiles.active=$APP_ENV "${JAR}"
