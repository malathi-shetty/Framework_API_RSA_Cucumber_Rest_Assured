Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI

Given Add Place Payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "Post" http request
# When user calls "getPlaceAPI" with "get" http request
Then the API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_Id created maps to "<name>" using "getPlaceAPI"

Examples:
  | name              | language   | address                   |
  | Frontline house   | French-IN  | 29, side layout, cohen 09 |
 # | AAhouse           | English    | World cross center        |
 # | BBhouse           | Spanish    | Sea life Agency           |
 
 @DeletePlace @Regression
 Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When user calls "deletePlaceAPI" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    
     # check httpmethod as in postman for delete