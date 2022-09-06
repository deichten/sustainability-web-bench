# sustainability-web-bench
This  mono-repo should collect sustainability benchmark of web-frameworks in different programming languages over time.

Each folder contains a different framework to be tested that also gets actually wrapped in a docker container. As we don't benchmark container sizes or build times this is not implemented (maybe an option for later). The only exception is loadgen which is a load generator that is using docker local networking to put some requests to the web frameworks being tested. The tests consist of:

- startup and idling (until 60 seconds are reached)
- execution of simple load generator scripts leading to 1 req/sec
- execution of maximum amount of request reachable (this test execution can vary in time required)

## Tooling used

- [Drill](https://github.com/fcsonline/drill) – a rather simple rust based performance testing tool
- [PowerTOP](https://github.com/fenrus75/powertop) – to measure energy consumption as this should give the highest compatibility

