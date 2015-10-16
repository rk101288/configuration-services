## Configuration Services

### How to run the application
* Install java 8
* ./gradlew clean build
* ./gradlew bootRun

Application will run on 8080 port. Make sure no other services are running.

### Endpoints

* Get all configurations - localhost:8080/configuration/getAll
* Get configuration by DB ID - localhost:8080/configuration/{uuid}
* Create new configuration - POST to localhost:8080/configuration. Sample payload:
{"name": "host3",
"hostname": "test1.lab.com",
"port": 5001,
"commonProperty": "something1",
"username": "test1" }
* Update a configuration - PUT to localhost:8080/configuration/{uuid}
* Delete a configuration - DELETE to localhost:8080/configuration/{uuid}