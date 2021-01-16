This application is based on Spring-boot, thus, for running, just following the steps:

Pre-requirements
---------------
- Java jdk 11
- Maven 3.0+
- Eclipse (this sourcecode was made on Oxygen version) (for code evaluation or executing the MainApplication easily)

Running
--------

- In you develop environment, execute: git clone https://github.com/leonardocalil/volvo-assessment.git
- Import the project in your eclipse environment
- Execute mvn clean install 
- Execute the method main existent in MainApplication


API - Microservices
---
- http://127.0.0.1:8080/address:
	- all
	- delete/{addressId}
	- saveUpdate
	- search/{zipcode}
- http://127.0.0.1:8080/customer:
	- all
	- delete/{documentId}
	- saveUpdate
	- search/{zipcode}	

- You can also find the detailed information and body json examples in the weblink http://127.0.0.1:8080/swagger-ui.html
