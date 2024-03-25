You can import this folder in IntelliJ, and run the application. It will start running on port 8080. 

Application has 3 Endpoints:

i) POST v1/tracker/petDetails
ii) GET v1/tracker/petDetails/{ownerId}
iii) GET v1/tracker/petsOutsideZone

Once application starts running. You can make the below Curl requests in relation to the above mentioned endpoints:

curl -s -w "HTTP ResponsX POST -H "Content-Type: application/json" -d '{
    "ownerId": 1,
    "petType": "DOG",
    "trackerType": "SMALL",
    "inZone": false,
    "lostTracker": false
}' http://localhost:8080/v1/tracker/petDetails

curl -s -w "HTTP ResponsX POST -H "Content-Type: application/json" -d '{
    "ownerId": 2,
    "petType": "CAT",
    "trackerType": "LARGE",
    "inZone": false,
    "lostTracker": false
}' http://localhost:8080/v1/tracker/petDetails

curl -s -w "HTTP Response Code: %{http_code}\n\nResponse Body: %{response_body}\n" "http://localhost:8080/v1/tracker/petDetails/2"

curl -s -w "HTTP Response Code: %{http_code}\n\nResponse Body: %{response_body}\n" "http://localhost:8080/v1/tracker/petsOutsideZone"
