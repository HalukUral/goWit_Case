# QA Engineer Test
- This framework is about Backend Automation Testing
- I started my work by analyzing API document
- Then I created my scenarios, and I executed them manually on Postman
- After this I wrote my test scripts by using RestAssured-Java.
- Framework supports parallel execution and data-driven testing
- Tools : Postman, Maven, Java, RestAssured, TestNG, Apache POI
## Following scenarios are executed in this framework and failed ones are declared.


### Create User Scenarios:
```bash
Scenario 1 : Create a new pet with valid information successfully (Positive Scenario)
Scenario 2 : Create a new pet with invalid Id type (Negative Scenario)
Scenario 3 : Create a new pet without picture(Negative Scenario)
            FAILED : User should not be created without picture
```
### Update User with PUT Request Scenarios:
```bash
Scenario 1 : Update a pet data by ID successfully(Positive Scenario) 
Scenario 2 : Update a pet's data without existing ID (Negative Scenario)
FAILED : User should not be update pet's data without existing ID
```
### Get User Data Scenarios:
```bash
Scenario 1 : Get a pet data by ID successfully(Positive Scenario) 
Scenario 2 : Get a pet data by invalid ID type (Negative Scenario)
```
### Get User Data Scenarios:
```bash
Scenario 1 : Delete a pet with valid id number(Positive Scenario) 
Scenario 2 : Delete a pet that is nonexistent(Negative Scenario)
Scenario 3 : Delete a pet with invalid id numbers(Negative Scenario)
```
