FROM ghcr.io/graalvm/native-image:ol8-java17-22 AS builder
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . .
RUN ./mvnw -f pom.xml -Pnative clean package

FROM debian:stable-slim
WORKDIR /work/
COPY --from=builder /usr/src/app/target/*-runner /work/application

# set up permissions for user `1001`
RUN chmod 775 /work /work/application \
  && chown -R 1001 /work \
  && chmod -R "g+rwX" /work \
  && chown -R 1001:root /work

EXPOSE 8080
USER 1001

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]