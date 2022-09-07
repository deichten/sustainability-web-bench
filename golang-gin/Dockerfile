FROM golang:1.19-alpine AS builder

RUN mkdir -p /app
WORKDIR /app
COPY . .
RUN go build -o app main.go

FROM alpine:3

WORKDIR /app/
COPY --from=builder /app/app /app/app

# set up permissions for user `1001`
RUN chmod 775 /app /app/app \
  && chown -R 1001 /app \
  && chmod -R "g+rwX" /app \
  && chown -R 1001:root /app

EXPOSE 8080
USER 1001

# swap to release mode
ENV GIN_MODE=release

ENTRYPOINT ["/app/app"]
