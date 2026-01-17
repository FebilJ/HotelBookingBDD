Feature: Book_DoubleRoom 
Scenario: Booking of double room for 3 days & 2 nights 
Given User on the Shady Meadows B&B
When User clicks Check-in date as "16/07/2026"
And User clicks Check-Out date as "18/07/2026"
And User clicks Check Availability button
Then Select Room Type Double
And User clicks the Reserve Now button
And User enters details as "Nathaniel" "Alexander" "nathaniel@gmail.com" "87764572572"
Then Booking Confirmed Message is Displayed


#Scenario: Booking suite room for 3 days and 2 nights with partner
 # Given User on the Shady Meadows B&B
 #When User selects check-in date as "16/02/2025"
 # And User selects check-out date as "18/02/2025" 
 # And User clicks Check Availability button
 #Then Select Suite Room Type
 # And User clicks the Reserve Now button
 # And User enters guest details for "John" "Doe" "john.doe@email.com" "9876543210"
 # Then Booking Confirmed Message is Displayed
  
  
  #need to add background
  #can include parameter for Room Type
  #check scroll