# Sustainability Web Bench

This mono-repo should collect sustainability benchmark of web-frameworks in different programming languages over time. Feel free to contribute.

## Reasonale

There are multiple benchmarks and studies that do exist trying to answer the question which programming languages are the most energy efficient ones, e.g. [*Ranking Programming Languages by Energy Efficiency*](https://haslab.github.io/SAFER/scp21.pdf). The problem with those is multifold:

- The algorithms of the benchmark are rather computation heavy and don't really replicate the reality of a web application
- It is stated that code from [RosettaCode](https://rosettacode.org) is used but as of writing this there are 7 different algorithms for Fibonacci in Rust alone. But it is not stated which algorithm was used – and just on my computer the iterative algorithm runs about 660ns to calculate ``fib(45)`` but almost 10sec using the recursive algorithm
- web applications can also differ in load pattern – from 0 requests to 1,000s of requests a second

Nevertheless the use of energy for web applications can play a significant role and therefore benchmarking languages and frameworks with each other is a really good idea.

## Idea
Creating a webbench simulating idling, low load and high load scenarios and looking into the energy consumption, the execution speed and drilled down from there the energy consumption per request.

Every implementation needs to implement a very simple calculator webservice taking path variables and returning a result. To make things easy for the load generator the service needs to answer plain http on port ``8080`` to run without root privileges and be wrapped into a container. I know that this is not ideal it will not allow for modern standards like *HTTP2* or *Quic* that do require TLS by default. So a call like 

```
curl localhost:8080/calc/add/2/3
```

should yield the result
```
{
    "result": 5
}
```

For right now this should give an idea on how frameworks behave in different situations. At a later point in time I guess it would make sense to add

- not only using ``GET`` method and path variables but also ``POST`` and a request object to be parsed and validated
- call to a slow external service (e.g. a database or external webservice) to simulate external calls and blocked reqeusts. This should ideally be a mocked service to make sure that results are comparable.

## Structure

Each folder (except loadgen) contains a different framework to be tested that gets wrapped in a docker container. Testing container sizes or build times is not part of the benchmark but I [recorded my results](BUILDTIMES.md) 

 The load generator uses docker local networking (could be moved to a cloud instance at a later point in time) and puts some requests to the frameworks. The tests consist of:

- startup and idling (for 60 seconds)
- execution of simple load generator scripts leading to 1 req/sec (leading to about 30 secs of requests)
- execution of maximum amount of request reachable (this test execution can vary in time required)

## How to execute

### Building

I'm planning to add Makefile or something similar later but for right now building everything is as easy as:

```
export CONTAINER_PREFIX="deichten/sus-wb-"
export CONTAINER_LABEL="latest"
for folder in *
do
  if [ -d $folder ]; then
    cd $folder;
    podman build -t ${CONTAINER_PREFIX}${folder}:${CONTAINER_LABEL} .
    cd ..
  fi
done
```

Depending on your machine this might take some time. As you can see in the [build times overview](BUILDTIMES.md) specifically containers that need a lot of dependencies or use compiled rather than interpreted languages will take some time. 

## Tooling used

- [Podman](https://podman.io) – for building and running the containers
- [Drill](https://github.com/fcsonline/drill) – a rather simple rust based performance testing tool
- [PowerTOP](https://github.com/fenrus75/powertop) – to measure energy consumption as this should give the highest compatibility

## TODO

- Build tooling scripting around everything 
- Make PowerTOP working on various machines (maybe find alternative)
- Add additional frameworks from node.js, Python, PHP
- Add Cloud configs to deploy load generator and framework under review onto different machines
- a lot more ...