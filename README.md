# transformation

Technical task of TechRivo

Endpoint:
--- /v1/transformation - POST
header : Content-type - `application/json`
body: ```json:
          { 
          "name" : "smth", 
          "items" : ["array", "of", "strings"]
          }```
          
response: 
    200 : 
        ```json:
             { 
             "name" : "smth", 
              "items" : ["array", "of", "strings"],
              "timestamp" : 163878392
              }```
              
   400
