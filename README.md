# Calculator
An API for a POC calculator.

### Third party libraries
- Spring Boot 2.5.7
    - spring-boot-starter-web
    - spring-boot-starter-test
    - spring-boot-maven-plugin
- Springfox 3.0.0
- [Mapstruct](https://mapstruct.org/) 1.5.3.
- openapi- generator

### Installation
To run and develop over this service you must have the following requirements:
- [OpenJDK 17](https://adoptopenjdk.net/installation.html#installers)
- [Maven 3.6.3](https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/).

Run `mvn clean verify` to check that everything works.

### Execution
You can start the service locally with
cd calculator
mvn spring-boot:run

### Endpoints
http://localhost:8080/simplecalculator/integer/add

http://localhost:8080/simplecalculator/integer/substract

### Local testing
To run the test from console:

mvn test