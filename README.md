This is a Minimal RESTful Calculator implemented with Core backend using JAVA Spring (Spring boot 2) REST APIs & Frontend using Angular 7 (https://angular.io/) / Angular Material design (https://material.angular.io).

Technology Stack
Component	Technology
Frontend	Angular 7
Backend (REST)	SpringBoot (Java)
REST Documentation	Swagger UI
REST Spec	Open API Standard
Client Build Tools	angular-cli, Webpack, npm
Server Build Tools	Maven(Java)
Spring Boot

Swagger UI
Swagger UI is used to document and test the REST API from browser. The console can be accessed from this address (http://localhost:8080/swagger-ui.html)

Getting Started
To install this example application, run the following commands:

git clone https://github.com/billu1990/Simple-Restful-Calculator.git
cd SimpleCalculator

This will get a copy of the project installed locally. To install all of its dependencies and start each app, follow the instructions below.

To run the backend, cd into thec folder and run:

mvn spring-boot:run

To run the client, cd into the rest-caclculator-app folder and run:

npm install && npm start

Accessing Application
Component	URL
Frontend	http://localhost:4500
Swagger (API Ref)	http://localhost:8080/swagger-ui.html
