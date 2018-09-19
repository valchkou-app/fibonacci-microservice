# fibonacci-microservice

## This Microservice implements 3 algorithms to calculate Nth Fibonacci number:

- Binet
- Loop
- Recursive

**Build:** _gradlew build_  
**Run:** _gradlew bootRun_

Microservice starts on random port.

As it runs you can access swagger api at: _**http://localhost:{port}**_

**Unit Test:** [FibonacciServiceTest.groovy](https://github.com/valchkou/fibonacci-microservice/blob/master/src/test/groovy/com/valchkou/cloud/service/FibonacciServiceTest.groovy)

**Integration Test:** [FibonacciControllerTest.groovy](https://github.com/valchkou/fibonacci-microservice/blob/master/src/test/groovy/com/valchkou/cloud/web/FibonacciControllerTest.groovy)


**Requres Java 8 to compile and run.**