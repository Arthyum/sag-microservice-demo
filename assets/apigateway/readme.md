

docker run --rm -it -w /opt/softwareag/Microgateway \
    store/softwareag/microgateway-trial:10.3 \
    /bin/sh

docker run --rm -v $(pwd)/apis:/opt/softwareag/Microgateway/apis \
    -w /opt/softwareag/Microgateway \
    store/softwareag/microgateway-trial:10.3 \
    /bin/sh
    
execute command to create a docker file



```
docker run --rm -v $(pwd)/apis:/opt/softwareag/Microgateway/apis \
    -w /opt/softwareag/Microgateway \
    store/softwareag/microgateway-trial:10.3 \
    /bin/sh -c './microgateway.sh createDockerFile --docker_dir . --docker_from registry.docker.tests/apis/sag-microservices-demo/fibonacci:10.3 -a apis/configs/passthru/fibonacci.zip -p 8889'
```