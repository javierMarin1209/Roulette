## API REST ROULETTE

### COMPONENTS DIAGRAM

| Component| Description|
| ----- | ---- |
| Redis | It's a in-memory data structure store |


### LOCATION OF PROPERTIES

**Properties**
	path: src/main/resources
	Name of the file: application.properties

#### Description of the files:
**application.properties:** It's a properties file that have a host and port of redis

#### Enpoints

|HTTP method| Endpoint URL|Description|
| ----- | ----- | ----- |
| POST | http://localhost:8080/api/roulette/create | It's the endpoint to create a roulette|
| PUT | http://localhost:8080/api/roulette/open/{id} | It's the endpoint to open a specific roulette|
| GET | http://localhost:8080/api/roulette/list | This endpoint list all the roulettes and the status of each one|
| POST | http://localhost:8080/api/bet/create | This endpoint create a new roulette, this validated a header "User"|
| PUT | http://localhost:8080/api/roulette/close/{id} | It's the endpoint to open a specific roulette|

#### Request objetcs

Endpoint: http://localhost:8080/api/bet/create
``` 
{
    "idRoulette":2,
    "number":36,
    "money":6000,
    "typeBet":"NUMBER",
    "color":"BLACK"
}
```



