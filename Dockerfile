FROM java:8

ENV APP_ENV dev

COPY ./build/libs/*.jar /app/
COPY ./enterpoint.sh /app/

EXPOSE 8080

CMD ["/app/enter-point.sh"]
