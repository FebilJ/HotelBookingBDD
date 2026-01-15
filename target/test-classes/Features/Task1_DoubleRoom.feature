Feature: Task1_DoubleRoom 
Scenario: Booking of double room for 3 days & 2 nights 
Given User on the Shady Meadows B&B booking website
When User clicks Check-in Date
And User clicks Check-Out Date
And User clicks Check Availability button
Then Double Room type from available options should be Selected
And User clicks the Reserve Now button
And User fill the required field and clicks Reserve Now button
Then Booking Confirmed Message is Displayed