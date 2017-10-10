# A simple CRUD API using Spring 5, Kotlin and MongoDB

### Requirements
- Java 8
- docker
- docker-compose
- gradle

### Running
`./go.sh`

### Stopping (without removing docker containers)
`./stop.sh`

### Stopping and removing all containers
`./teardown.sh`

### Using the API

##### Create a thing
`curl -XPOST -H 'Content-Type: application/json' 'http://localhost:45678/v1/things' -d '{"name": "My thing"}'`

##### List all the things
`curl 'http://localhost:45678/v1/things'`

##### Get the thing
`curl 'http://localhost:45678/v1/things/{id}'`

##### Delete the thing
`curl -XDELETE 'http://localhost:45678/v1/things/{id}'`