# gs-rest-service-complete
Note : Application is Build using Gradle , maven is not used.
The project is a springboot project solving problems given in challenge about temperature , stocks and cars




1. Stock Price for a  company - 
>>  In case you do not provid currency all currency values for a particular stock will be shown , otherwise a stock price for a given value is only shown 

(post request )
http://localhost:8080/stockPrice  
header  Header - 
Content-Type : application/json

request JSON 1  :- 
{
"stockExchangeCode" : "gogl",
"stockValueInDiffCurrencies" : []
}

reponse JSON 1  :- 

{
  "stockId": 1,
  "stockExchangeCode": "gogl",
  "stockValueInUsd": 200,
  "stockValueInDiffCurrencies": [
    {
      "currId": 1,
      "stockCurrencyUnit": "INR",
      "stockCurrencyValue": 12000
    },
    {
      "currId": 2,
      "stockCurrencyUnit": "CAN",
      "stockCurrencyValue": 400
    },
    {
      "currId": 3,
      "stockCurrencyUnit": "AUS",
      "stockCurrencyValue": 600
    }
  ]
}


request JSON 2  :- 
{
"stockExchangeCode" : "gogl",
"stockValueInDiffCurrencies" : [{
      "stockCurrencyUnit": "INR"
    }]
}

reponse JSON 2  :- 

{
  "stockId": 1,
  "stockExchangeCode": "gogl",
  "stockValueInUsd": 200,
  "stockValueInDiffCurrencies": [
    {
      "currId": 1,
      "stockCurrencyUnit": "INR",
      "stockCurrencyValue": 12000
    }
  ]
}

================================================================================
2. Random Temperature for  a City :- 

(post request )
http://localhost:8080/cityTemp
header  Header - 
Content-Type : application/json

request JSON 1 :- 

{
"cityCode":"DEL",
"unit":"F"
}

reponse JSON 1 :- 

{
  "id": 1,
  "cityCode": "DEL",
  "temperature": 93.2,
  "unit": "F"
}

request JSON 2 :- 
{
"cityCode":"GGN",
"unit":"F"
}

reponse JSON 2 :- 

{
  "id": 2,
  "cityCode": "GGN",
  "temperature": 68,
  "unit": "F"
}


===================================================
3. random price of a Car :- 

(post request )
http://localhost:8080/priceOfCar
header  Header - 
Content-Type : application/json

request JSON 1 :- 
{
 "manufacturer":"Fiat",
 "model":"Linea"	
}


response JSON 1 :- 
{
  "id": 2,
  "manufacturer": "Fiat",
  "model": "Linea",
  "primaryPriceUnit": "INR",
  "secondaryPriceUnit": "USD",
  "primaryPriceUnitValue": 13000,
  "secondaryPriceUnitValue": 780000
}

========================================================

Exception Handling :- 

1. Exception handling for Car Price use case :- 
In case of wrong car model or/and manufacturer :- 

input JSON :- 

{
 "manufacturer":"asdfsafsdf",
 "model":"Linea"
	
}


output JSON :- 

{
  "timestamp": 1492975312764,
  "status": 500,
  "error": "Internal Server Error",
  "exception": "lakshya.exceptions.CarNotFoundException",
  "message": "LocalException : Model and manufacturer not found",
  "path": "/priceOfCar"
}

================================================

2. Exception Handling for Stock price use case :- 

input JSON :- 

{
"stockExchangeCode" : "asdffasfdsaf",
"stockValueInDiffCurrencies" : [{
      "stockCurrencyUnit": "INR"
    }]
}


output JSON :- 
{
  "timestamp": 1492974127902,
  "status": 500,
  "error": "Internal Server Error",
  "exception": "java.lang.Exception",
  "message": "Global Exception : value for stock not found",
  "path": "/stockPrice"
}

============================================
3. Exception handling for temperature use case :- 


Input JSON 

{
"cityCode":"asdffsdf",
"unit":"F"
}


output JSON :- 

{
  "timestamp": 1492974106859,
  "status": 500,
  "error": "Internal Server Error",
  "exception": "java.lang.Exception",
  "message": "Global Exception : CityCode not found , Please provide correct City Code",
  "path": "/cityTemp"
}

