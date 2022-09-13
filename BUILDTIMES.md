# Build Times & Container Sizes

## MacBook Pro 16" (2021) – M1 Pro – 32GB RAM – podman

All build and ship container images pre-pulled so only dependencies during build had to be downloaded.

| Image | Build Time (sec) | Size (MB) | StartUp time (sec) | Comment |
|:---|---:|---:|---:|:---|
| Golang Gin | 9.45 | 26 |  |  |
| Quarkus GraalVM (native) | 117.76 | 170 | 0.1 | Build time includes test execution |
| SpringBoot OpenJDK | 35.94 | 426 | 1.3 | Build times includes test execution |
| Rust Warp | 60.28 | 92.7 |  | Container size could go towards Golang's size also using alpine and compiling for musl. |