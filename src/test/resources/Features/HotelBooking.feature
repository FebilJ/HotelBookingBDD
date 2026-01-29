Feature: Hotel Booking Automation - Shady Meadows B&B 
  Purpose: Automated testing of room booking functionality
  Scope: Positive scenarios for Single, Double, Suite rooms
  Author: Febil Jose Babu
  
Background:
	Given User on the Shady Meadows B&B

# Task 1: Personal booking Scenario for Double Room
Scenario: Booking of DOUBLE ROOM for 3 days & 2 nights
	When User clicks Check-in date as "16/10/2026"
	And User clicks Check-Out date as "18/10/2026"
	And User clicks Check Availability button
	Then Select Room Type "DOUBLE"
	And User clicks the Reserve Now button
	And User enters details as "Nathaniel" "Alexander" "nathaniel@gmail.com" "87764572572"
	Then Booking Confirmed Message is Displayed

# Task 2.a: Personal booking Scenario for Suite Room
Scenario: Booking SUITE ROOM for 3 days and 2 nights with partner 
	When User selects check-in date as "16/02/2025"
	And User selects check-out date as "18/02/2025"
	And User clicks Check Availability button
	Then Choose Room Type "SUITE"
	And User clicks the Reserve Now button
	And User enters guest details for "Johnathan" "Maverick" "johna.mav@email.com" "98765433210"
	Then Booking Confirmed Message is Displayed

# Task 2.b: Bachelor Booking Scenario for Single Room
Scenario: Booking SINGLE ROOM for 2 days and 1 night for bachelor friend 
	When User chooses check-in date as "16/02/2025"
	And User chooses check-out date as "17/02/2025"
	And User clicks Check Availability button
	Then Book Room Type "SINGLE"
	And User clicks the Reserve Now button
	And User enters guest details for "Johnson" "Williams" "johns.wills@email.com" "95625433210"
	Then Booking Confirmed Message is Displayed

# Task 2.c: Friend & his Partner Booking Scenario for Suite Room
Scenario: Booking SUITE ROOM for 3 days and 2 nights with partner 
	When User Clicks check-in date as "16/02/2025"
	And User Clicks check-out date as "18/02/2025"
	And User clicks Check Availability button
	Then Select Room Type "SUITE"
	And User clicks the Reserve Now button
	And User enters guest details for "Christopher" "Dominic" "christopher@email.com" "98765431235"
	Then Booking Confirmed Message is Displayed
 

# Task 3: Unhappy Paths Scenarios
# NOTE: The scenarios below are written as part of Task 3,
# but the automation code is not implemented yet.

#Scenario: Booking fails when room is not available for selected dates
  	#When User selects check-in date "16/08/2026"
  	#And User selects check-out date "18/08/2026"
  	#And User checks room availability
  	#Then The room booking option should not be displayed
  	#And User should not be able to reserve a room

#Scenario: Booking fails when guest details are shorter than required length
	#When User selects check-in date "16/08/2026"
	#When User selects check-in date "16/08/2026"
  	#And User selects check-out date "18/08/2026"
  	#And User checks room availability
  	#And User selects room type "DOUBLE"
  	#And User reserves the room
  	#And User enters guest details "N" "A" "a@b.com" "123"
  	#Then An error message should be displayed for invalid guest details length