# Project Title

  Tracker-Service in Java Spring Boot. 

## Description 

  Import the folder in Intellij. Run the application, it should start listening on Port 8080. Tracker-Service has 3 API's at the moment mentioned below.  
  
  1) POST v1/tracker/petDetails 
  2) GET v1/tracker/petDetails/{ownerId} 
  3) GET v1/tracker/petsOutsideZone

## API Usage Examples

### Request 1: POST Request

```bash
curl -s -w "HTTP Response Code: %{http_code}\n\nResponse Body: %{response_body}\n" -X POST -H "Content-Type: application/json" -d '{
    "ownerId": 1,
    "petType": "DOG",
    "trackerType": "SMALL",
    "inZone": false,
    "lostTracker": null
}' "http://localhost:8080/v1/tracker/petDetails"

curl -s -w "HTTP Response Code: %{http_code}\n\nResponse Body: %{response_body}\n" -X POST -H "Content-Type: application/json" -d '{
    "ownerId": 2,
    "petType": "CAT",
    "trackerType": "LARGE",
    "inZone": false,
    "lostTracker": false
}' "http://localhost:8080/v1/tracker/petDetails"
```
### Request 2: GET Request

```bash
curl -s -w "HTTP Response Code: %{http_code}\n\nResponse Body: %{response_body}\n" "http://localhost:8080/v1/tracker/petDetails/2"
```
### Request 3: GET Request

```bash
curl -s -w "HTTP Response Code: %{http_code}\n\nResponse Body: %{response_body}\n" "http://localhost:8080/v1/tracker/petsOutsideZone"
```

