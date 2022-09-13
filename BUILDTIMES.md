# Build Times & Container Sizes

## MacBook Pro 16" (2021) – M1 Pro – 32GB RAM – podman

All build and ship container images pre-pulled so only dependencies during build had to be downloaded.

| Image | Build Time (sec) | Size (MB) | StartUp time (sec) | Comment |
|:---|---:|---:|---:|:---|
| Golang – Gin | 9.45 | 26 | (tbm) |  |
| Java – Quarkus <br />(GraalVM native) | 117.76 | 170 | 0.1 | Build time includes test execution |
| Java – SpringBoot <br /> (OpenJDK) | 35.94 | 426 | 1.3 | Build times includes test execution |
| Rust – Warp | 60.28 | 92.7 | tbm | Container size could go towards Golang's size also using alpine and compiling for musl. |
| TypeScript – Express | 20.93 | 186 | tbm | Build time could be optimizes by copying node_modules from build container but would then potentially also leak development dependencies into prod container. Additionally times can go up with bigger projects and more dependencies. |