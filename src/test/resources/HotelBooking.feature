@hotelBooking
Feature: Create and Delete a hotel booking
  As a product manager
  I want the customer to be able to create/delete a booking
  So that they can book/cancel their hotel booking for any day

  Scenario: Create a booking from first saturday of next month
    Given the customer navigates to the hotel booking page
    When the customer creates the booking with below details:
      | FirstName | LastName | Price | Deposit |
      | Matthew   | Skidmore |  1000 | false   |
    Then new booking should be displayed on the booking page

  Scenario: Customer deletes the first booking on the booking page
    Given the customer navigates to the hotel booking page
    When the customer deletes the first booking on the page
    Then the first booking should not be visible on the booking page
