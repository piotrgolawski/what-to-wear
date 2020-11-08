### Test project with Java, Spring and Drools. 
It can calculate what you should get with you for an airplane trip. 

It calls WeatherApi (https://www.weatherapi.com/) so you need to pass your token into config. The free version of that API allows us to forecast to 3 days in front.
And then program parse those data and pass it into the drools rule engine. The result of this is merged and returned in a friendly form.

You need to send for example
```
POST /airplane-trip HTTP/1.1
Host: localhost:8080
Content-Type: application/json
charset: UTF-8

{
	"from": "Berlin",
	"to": "Bahamas",
	"days": 10
}

```

and you will receive something like this 

```
{
    "youWillNeedBeforeFlight": "Jacket",
    "youWillNeedAfterFlight": "Windbreaker Jacket, Umbrella, Wellingtons, Jacket, Suncream, Cap",
    "weatherBeforeFlight": {
        "tempC": 8.8,
        "windKph": 11.9,
        "uv": 1,
        "rainMM": 0
    },
    "weatherAfterFlight": [
        {
            "tempC": 21.2,
            "windKph": 54,
            "uv": 5,
            "rainMM": 3.1
        },
        {
            "tempC": 19.8,
            "windKph": 55.4,
            "uv": 5,
            "rainMM": 3
        },
        ...
    ]
}
```

## What to do next
 - Add measurement time to response weatherAfterFlight
 - Refactor code
 - Write some more tests
 - Integrate jBPM
