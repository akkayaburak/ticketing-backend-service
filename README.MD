# Ticketing BackEnd Service

A backend service application for the airline ticketing system.

## Technologies

- JAVA
- Maven
- Spring Boot
- Hibernate
- JPA
- H2 Database
- RESTful Web Service
- Postman


## Usage

You can change and see credentials at `application.properties` file.
You can access to **H2** via `localhost:8080/h2-console` by default.
In `data.sql` file some inserts have been made for easy testing.


## Examples

Tests made with Postman.

`GET localhost:8080/ticketing/airlines`
```
[
    {
        "airlineId": 1,
        "airlineName": "THY"
    },
    {
        "airlineId": 2,
        "airlineName": "Pegasus"
    }
]
```

`POST localhost:8080/ticketing/airlines`
```
{
    "airlineName" : "AnadoluJet"
}
```
Returns:
```
{
    "airlineId": 3,
    "airlineName": "AnadoluJet"
}
```

`GET localhost:8080/ticketing/airports/1`
```
[
    {
        "airportId": 1,
        "airportName": "Ataturk"
    }
]
```
`GET localhost:8080/ticketing/rotas/2`
```
{
    "rotaId": 2,
    "airline": {
        "airlineId": 2,
        "airlineName": "Pegasus"
    },
    "whereAirport": {
        "airportId": 3,
        "airportName": "Yenisehir"
    },
    "toAirport": {
        "airportId": 2,
        "airportName": "Sabiha Gokcen"
    }
}
```

` POST localhost:8080/ticketing/flights`
```
{
  "date" : "2020-07-27",
  "quota" : 50,
  "price" : 100,
  "rota": {
      "rotaId" : 1
  } 
}
```
`GET localhost:8080/ticketing/flights/2`
```
{
    "flightId": 2,
    "quota": 20,
    "date": "2020-06-27",
    "rota": {
        "rotaId": 2,
        "airline": {
            "airlineId": 2,
            "airlineName": "Pegasus"
        },
        "whereAirport": {
            "airportId": 3,
            "airportName": "Yenisehir"
        },
        "toAirport": {
            "airportId": 2,
            "airportName": "Sabiha Gokcen"
        }
    },
    "price": 200
}
```
`POST localhost:8080/ticketing`
```
{
 "creditCard" : "4221161122330005",
 "flight" : {
     "flightId" : 1
 }
}
```
`GET localhost:8080/ticketing/2`
```
{
    "ticketId": 2,
    "creditCard": "422116******0005",
    "flight": {
        "flightId": 1,
        "quota": 50,
        "date": "2020-07-27",
        "rota": {
            "rotaId": 1,
            "airline": {
                "airlineId": 1,
                "airlineName": "THY"
            },
            "whereAirport": {
                "airportId": 2,
                "airportName": "Sabiha Gokcen"
            },
            "toAirport": {
                "airportId": 1,
                "airportName": "Ataturk"
            }
        },
        "price": 100
    }
}
```
## Documentation

`https://documenter.getpostman.com/view/12158072/T1DtdFJG`

## License
[MIT](https://choosealicense.com/licenses/mit/)