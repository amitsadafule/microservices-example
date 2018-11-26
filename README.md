This project consists of basic components and examples required to build a microservice system.
Tools used
1. Eureka - service registration and discovery, Naming server
2. Ribbon - client side load balancing
3. Feign - connecting other services
4. Zuul - Api gateway
5. sleuth - for distributed tracing


Installations:
https://www.rabbitmq.com/install-homebrew.html
https://zipkin.io/pages/quickstart.html

How to run
1. rabbit MQ : /usr/local/sbin/rabbitmq-server
2. zipkin : RABIT_URI=amqp://localhost java -jar zipkin.jar
3. Go to zipkin dashboard : http://localhost:9411/zipkin/
4. Go to Eureka dashboard : http://localhost:8761/
5. Go to h2 console : http://localhost:8000/h2-console/
6. 