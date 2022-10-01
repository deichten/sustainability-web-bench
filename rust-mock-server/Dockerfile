FROM rust:slim AS builder

WORKDIR /app
RUN mkdir -p /app
COPY . .
RUN cargo build -r

FROM debian:stable-slim 

WORKDIR /app
COPY --from=builder /app/target/release/rust-mock-server /app/rust-mock-server

RUN chmod 775 /app /app/rust-mock-server \
  && chown -R 1001 /app \
  && chmod -R "g+rwX" /app \
  && chown -R 1001:root /app

EXPOSE 3001
USER 1001

ENTRYPOINT [ "/app/rust-mock-server" ]