# sag-microservice-demo

A small demo showing how to build microservices with webMethods Microservice Container, 
using the built-in Consul integration for service discovery, circuit-breaker pattern for self-healing, and docker-swarm for self-scaling

The demo starts a Consul cluster (3 Consul servers, 3 Consul Agents) and 4 Microservice Container, each with their own REST endpoints.

## Run the demo

Build the docker images:

```
docker-compose -f docker-compose-build.yml build
```

Run the project:

```
docker-compose up -d
```

## Demo Microservices

Consul UI: http://localhost:8500/ui/
In the UI, you should see the microservices getting regoistered as they come up.

The demo micro services are defined as follow:

- IP locator service
  - Endpoint: http://localhost:5556/restv2/iplocator/{ipv4}
  - Example:
  ```
  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -u Administrator:manage -X GET http://localhost:5556/restv2/iplocator/208.80.152.201
  ```
  
- User Info service (mock a DB call by returning random user data)
  - Endpoint: http://localhost:5557/restv2/userinfo/{userId:someAlphaNumericalValue - Or empty -- will generate something random for you}
  - Example:
  ```
  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -u Administrator:manage -X GET http://localhost:5557/restv2/userinfo/
  ```
  
- Fibonacci serie
  - Endpoint: http://localhost:5558/restv2/NextNumber/{positive number: index in the serie}
  - Example:
  ```
  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -u Administrator:manage -X GET http://localhost:5558/restv2/NextNumber/123
  ```
  
- Macro User Info Service that aggregates the User Info + IP location of the user
  - Endpoint: http://localhost:5555/restv2/userdetails/{userId:someAlphaNumericalValue}
  - Example:
  ```
  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -u Administrator:manage -X GET http://localhost:5555/restv2/userdetails/
  ```