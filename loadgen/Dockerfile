FROM rust:slim AS builder

RUN apt update && \
    apt install -y --no-install-recommends pkg-config libssl-dev && \
    cargo install drill

FROM debian:stable-slim

WORKDIR /root
COPY --from=builder /usr/local/cargo/bin/drill /bin/drill
COPY *.yaml .

ENTRYPOINT [ "/bin/drill" , "-s", "--benchmark"]