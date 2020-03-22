Feature: Testing the erail webpage

Scenario Outline:: TC-001_Getting the trains availability between stations
Given Open the erail web application
And Enter the <From> station
And Enter the <To> Station
Then Click on enter button


Examples:
|From|To|
|Chennai|Mumbai|


Scenario Outline: TC-002_Finding the number of Trains
Given Open the erail web application
And Enter the <From> station
And Enter the <To> Station
Then Click on enter button
And find all the train names

Examples:
|From|To|
|Chennai|Mumbai|
