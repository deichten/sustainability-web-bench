FROM rust:slim AS builder

WORKDIR /app
RUN mkdir -p /app
COPY . .
RUN cargo build -r

FROM debian:stable-slim 

WORKDIR /app
COPY --from=builder /app/target/release/rust-warp /app/rust-warp

RUN chmod 775 /app /app/rust-warp \
  && chown -R 1001 /app \
  && chmod -R "g+rwX" /app \
  && chown -R 1001:root /app

EXPOSE 8080
USER 1001

ENTRYPOINT [ "/app/rust-warp" ]